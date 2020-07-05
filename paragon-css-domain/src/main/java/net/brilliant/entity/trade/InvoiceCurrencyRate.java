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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.brilliant.framework.entity.RepoEntity;

/**
 *
 * @author haky
 */
@Entity
@Table(name="INVOICE_CURRENCY_RATE")
public class InvoiceCurrencyRate extends RepoEntity {

    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    @JoinColumn(name="INVOICE_ID")
    private Invoice invoice;
    
    @ManyToOne
    @JoinColumn(name="CURRENCY_PAIR_ID")
    private CurrencyPair currencyPair;

    @Column(name="BID", precision=10, scale=2)
    private BigDecimal bid = BigDecimal.ZERO;
    
    @Column(name="ASK", precision=10, scale=2)
    private BigDecimal ask = BigDecimal.ZERO;

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public CurrencyPair getCurrencyPair() {
        return currencyPair;
    }

    public void setCurrencyPair(CurrencyPair currencyPair) {
        this.currencyPair = currencyPair;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "InvoiceCurrencyRate[id=" + getId() + "]";
    }

}
