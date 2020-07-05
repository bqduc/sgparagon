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

package net.brilliant.entity.stock;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.brilliant.framework.entity.RepoEntity;

/**
 * @author bilga
 *
 */
@Entity
@Table(name = "PRODUCT_UNIT")
public class ProductUnit extends RepoEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private InventoryDetail product;

	@Column(name = "CHANGE_UNIT")
	private String changeUnit;

	@Column(name = "CHANGE_UNIT_VALUE")
	private BigDecimal changeUnitValue;

	@Column(name = "MAIN_UNIT")
	private String mainUnit;

	@Column(name = "MAIN_UNIT_VALUE")
	private BigDecimal mainUnitValue = BigDecimal.ONE;

	@Column(name = "BARCODE1")
	private String barcode1;

	@Column(name = "BARCODE2")
	private String barcode2;

	@Column(name = "BARCODE3")
	private String barcode3;

	@Column(name = "DEFAULT_UNIT")
	private Boolean defaultUnit = false;

	@Override
	public String toString() {
		return getChangeUnit();
	}

	public void setProduct(InventoryDetail product) {
		this.product = product;
	}

	public InventoryDetail getProduct() {
		return product;
	}

	public void setMainUnit(String mainUnit) {
		this.mainUnit = mainUnit;
	}

	public String getMainUnit() {
		return mainUnit;
	}

	public void setBarcode1(String barcode1) {
		this.barcode1 = barcode1;
	}

	public String getBarcode1() {
		return barcode1;
	}

	public void setBarcode2(String barcode2) {
		this.barcode2 = barcode2;
	}

	public String getBarcode2() {
		return barcode2;
	}

	public void setBarcode3(String barcode3) {
		this.barcode3 = barcode3;
	}

	public String getBarcode3() {
		return barcode3;
	}

	public void setChangeUnit(String changeUnit) {
		this.changeUnit = changeUnit;
	}

	public String getChangeUnit() {
		return changeUnit;
	}

	public void setChangeUnitValue(BigDecimal changeUnitValue) {
		this.changeUnitValue = changeUnitValue;
	}

	public BigDecimal getChangeUnitValue() {
		return changeUnitValue;
	}

	public void setMainUnitValue(BigDecimal mainUnitValue) {
		this.mainUnitValue = mainUnitValue;
	}

	public BigDecimal getMainUnitValue() {
		return mainUnitValue;
	}

	public void setDefaultUnit(Boolean defaultUnit) {
		this.defaultUnit = defaultUnit;
	}

	public Boolean getDefaultUnit() {
		return defaultUnit;
	}

}
