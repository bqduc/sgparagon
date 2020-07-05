/*
 * Copyleft 2007-2011 Ozgur Yazilim A.S.
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 * http://www.gnu.org/licenses/lgpl.html
 *
 * www.tekir.com.tr
 * www.ozguryazilim.com.tr
 *
 */

package net.brilliant.entity.trade;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.brilliant.entity.general.MoneySet;
import net.brilliant.framework.entity.RepoEntity;

/**
 * Fatura Üzerinde yer alan tüm döviz toplamlarını gruplu olarak tutar...
 * @author haky
 */
@Entity
@Table(name="INVOICE_CURRENCY_SUMMARY")
public class InvoiceCurrencySummary extends RepoEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name="INVOICE_ID")
    private Invoice invoice;
    
    @Column(name="CURRENCY", length=3)
    private String currency;
    
    @Embedded
    @AttributeOverrides( {
        @AttributeOverride(name="currency", column=@Column(name="CCY")),
        @AttributeOverride(name="value",    column=@Column(name="CCYVAL")),
        @AttributeOverride(name="localAmount", column=@Column(name="LCYVAL"))
    })
    private MoneySet amount = new MoneySet();

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public MoneySet getAmount() {
        return amount;
    }

    public void setAmount(MoneySet amount) {
        this.amount = amount;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "InvoiceCurrencySummary[id=" + getId() + "]";
    }

}
