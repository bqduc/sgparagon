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
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import net.brilliant.entity.trade.inv.TekirInvoice;
import net.brilliant.framework.entity.RepoEntity;
import net.brilliant.model.PaymentPlanCalcType;
import net.brilliant.model.PaymentPlanDestType;

/**
 * Faturanın ödeme planı bilgilerini tutar.
 * 
 * @author sinan.yumak
 *
 */
@Entity
@Table(name="INVOICE_PAYMENTPLAN_ITEM")
public class InvoicePaymentPlanItem extends RepoEntity {

	private static final long serialVersionUID = 1L;
    @ManyToOne
    @JoinColumn(name="OWNER_ID")
    @ForeignKey(name="FK_INVOICEPAYMENTPLAN_INVOICEID")
    private TekirInvoice owner;
    
    @Column(name="PAYMENT_DATE")
    private Date date;
    
    /**
     * Hesaplama tipi
     */
    @Column(name="CALC_TYPE")
    @Enumerated(EnumType.ORDINAL)
	private PaymentPlanCalcType calcType;
    
    /**
     * Hedef (Tutar üzerinden, Vergi üzerinden)
     */
    @Column(name="DEST_TYPE")
    @Enumerated(EnumType.ORDINAL)
    private PaymentPlanDestType destType;
    
    @Column(name="RATE", precision=10, scale=2)
    private BigDecimal rate = BigDecimal.ZERO;
    
    /**
     * Satır için hesaplanan tutar bilgisidir.
     */
    @Column(name="TOTAL", precision=10, scale=2)
    private BigDecimal total = BigDecimal.ZERO;

    @Column(name="PAID_TOTAL", precision=10, scale=2)
    private BigDecimal paidTotal = BigDecimal.ZERO;

    /**
     * Vadenin tamamının ödenip ödenmediği bilgisini tutar.
     */
    @Column(name="CLOSED")
    private boolean closed = false;
    
    @Column(name="LINE_NUMBER")
    private int lineNumber = 0;
    
    public InvoicePaymentPlanItem clone() {
    	InvoicePaymentPlanItem clonedppi = new InvoicePaymentPlanItem();
    	clonedppi.setCalcType(calcType);
    	clonedppi.setClosed(closed);
    	clonedppi.setDate(date);
    	clonedppi.setDestType(destType);
    	clonedppi.setLineNumber(lineNumber);
    	clonedppi.setPaidTotal(paidTotal);
    	clonedppi.setRate(rate);
    	clonedppi.setTotal(paidTotal);
    	return clonedppi;
    }
    
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public PaymentPlanCalcType getCalcType() {
		return calcType;
	}

	public void setCalcType(PaymentPlanCalcType calcType) {
		this.calcType = calcType;
	}

	public PaymentPlanDestType getDestType() {
		return destType;
	}

	public void setDestType(PaymentPlanDestType destType) {
		this.destType = destType;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (getId() != null ? getId().hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		return "InvoicePaymentPlanItem[id=" + getId() + "]";
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public BigDecimal getPaidTotal() {
		return paidTotal;
	}

	public void setPaidTotal(BigDecimal paidTotal) {
		this.paidTotal = paidTotal;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public TekirInvoice getOwner() {
		return owner;
	}

	public void setOwner(TekirInvoice owner) {
		this.owner = owner;
	}
	
}
