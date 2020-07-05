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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.brilliant.framework.entity.RepoEntity;
import net.brilliant.model.PaymentPlanCalcType;
import net.brilliant.model.PaymentPlanDestType;

@Entity
@Table(name = "PAYMENT_PLAN_ITEM")
public class PaymentPlanItem extends RepoEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "PAYMENT_PLAN_ID")
	private PaymentPlan paymentPlan;

	@Column(name = "PAYMENT_DAY")
	private Integer day;

	/**
	 * Hesaplama tipi
	 */
	@Column(name = "CALC_TYPE")
	@Enumerated(EnumType.ORDINAL)
	private PaymentPlanCalcType calcType = PaymentPlanCalcType.Rate;

	/**
	 * Hedef (Tutar üzerinden, Vergi üzerinden)
	 */
	@Column(name = "DEST_TYPE")
	@Enumerated(EnumType.ORDINAL)
	private PaymentPlanDestType destType = PaymentPlanDestType.Total;

	@Column(name = "RATE", precision = 17, scale = 2)
	private BigDecimal rate = BigDecimal.ZERO;

	public PaymentPlanItem clone() {
		PaymentPlanItem clonedppi = new PaymentPlanItem();
		clonedppi.setCalcType(calcType);
		clonedppi.setDay(day);
		clonedppi.setDestType(destType);
		clonedppi.setRate(rate);
		return clonedppi;
	}

	public PaymentPlan getPaymentPlan() {
		return paymentPlan;
	}

	public void setPaymentPlan(PaymentPlan paymentPlan) {
		this.paymentPlan = paymentPlan;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
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
		return "PaymentPlanItem[id=" + getId() + "]";
	}

}
