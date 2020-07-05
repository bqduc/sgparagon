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

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.brilliant.entity.general.Money;
import net.brilliant.framework.entity.RepoEntity;

/**
 *
 * @author haky
 */
@Entity
@Table(name="INVOICE_TAX_SUMMARY")
public class InvoiceTaxSummary extends RepoEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name="INVOICE_ID")
    private Invoice invoice;
    
    @ManyToOne
    @JoinColumn(name="TAX_ID")
    private Tax tax;
    
    @Column(name="RATE", precision=10, scale=2)
    private BigDecimal rate = BigDecimal.ZERO;
    
    @Embedded
    @AttributeOverrides( {
        @AttributeOverride(name="currency", column=@Column(name="CCY")),
        @AttributeOverride(name="value",    column=@Column(name="CCYVAL")),
        @AttributeOverride(name="localAmount", column=@Column(name="LCYVAL"))
    })
    private Money amount = new Money();

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "com.ut.tekir.entities.InvoiceTaxSummary[id=" + getId() + "]";
    }

}
