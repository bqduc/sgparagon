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

package net.brilliant.entity.general;

import java.math.BigDecimal;
import java.text.NumberFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author haky
 */
@Embeddable
public class Quantity implements java.io.Serializable {
	private static final long serialVersionUID = -8871186569561849667L;

	@ManyToOne
	@JoinColumn(name = "unit_id", insertable = false, updatable = false)
	private MeasureUnit measureUnit = new MeasureUnit();

	@Column(name = "quantity", precision = 5, scale = 2)
	private Double value = 0d;

	public Quantity() {
	}

	public Quantity(MeasureUnit measureUnit, Double value) {
		this.measureUnit = measureUnit;
		this.value = value;
	}

	public Quantity(final Quantity quantity) {
		this.measureUnit = quantity.getMeasureUnit();
		this.value = quantity.getValue();
	}

	public void moveFieldsOf(Quantity anotherQuantity) {
		if (anotherQuantity != null) {
			this.measureUnit = anotherQuantity.getMeasureUnit();
			this.value = anotherQuantity.getValue();
		}
	}

	public BigDecimal asBigDecimal() {
		return BigDecimal.valueOf(value);
	}

	@Override
	public String toString() {

		NumberFormat f = NumberFormat.getInstance();
		f.setMaximumFractionDigits(2);
		f.setMinimumFractionDigits(2);

		return f.format(getValue()) + "#" + getMeasureUnit().getCode();
	}

	public String toStringInNarrowFormat() {
		NumberFormat f = NumberFormat.getInstance();
		f.setMaximumFractionDigits(2);
		f.setMinimumFractionDigits(2);

		String result = f.format(getValue()) + "#" + getMeasureUnit().getCode();
		if (result.length() > 7) {
			result = result.substring(0, 7);
		}
		return result;
	}

	public boolean isZero() {
		return this.value == 0d;
	}

	public MeasureUnit getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(MeasureUnit measureUnit) {
		this.measureUnit = measureUnit;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}
