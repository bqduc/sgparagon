/*
* Copyright 2018, Bui Quy Duc
* by the @authors tag. See the LICENCE in the distribution for a
* full listing of individual contributors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* http://www.apache.org/licenses/LICENSE-2.0
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package net.brilliant.entity.crx;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.brilliant.entity.contact.CTAContact;
import net.brilliant.entity.general.PosTax;
import net.brilliant.entity.stock.InventoryDetail;
import net.brilliant.framework.entity.RepoAuditable;

/**
 * A order detail class.
 * 
 * @author Bui Quy Duc
 */
@Entity
@Table(name = "biz_order_detail")
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor 
@AllArgsConstructor
public class BizOrderDetail extends RepoAuditable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5144565849504790423L;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private InventoryDetail entry;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private BizOrder bizOrder;

	@ManyToOne
	@JoinColumn(name = "tax_class_id")
	private PosTax taxClass;

	@Digits(integer=12, fraction=2)
	@Column(name = "quantity")
	private Float quantity;

	@Digits(integer=12, fraction=2)
	@Column(name = "unit_price")
	private BigDecimal unitPrice;

	@Digits(integer=12, fraction=2)
	@Column(name = "list_price")
	private BigDecimal listPrice;

	@Digits(integer=12, fraction=2)
	@Column(name = "cost_price")
	private BigDecimal costPrice;

	@Digits(integer=12, fraction=2)
	@Column(name = "discount_price")
	private BigDecimal discountPrice;

	@Digits(integer=12, fraction=2)
	@Column(name = "extended_price")
	private BigDecimal extendedPrice;

	@Digits(integer=12, fraction=2)
	@Column(name = "pricing_formula")
	private String pricingFormula;

	@Digits(integer=12, fraction=2)
	@Column(name = "pricing_factor")
	private Float pricingFactor;

	@ManyToOne
	@JoinColumn(name = "support_contact_id")
	private CTAContact supportContact;

	@Column(name = "support_name", length=50)
	private String supportName;

	@Column(name = "support_term", length=250)
	private String supportTerm;

	@Column(name = "support_description", length=250)
	private String supportDescription;
	
  @Column(name="date_order_shipped")
	@DateTimeFormat(iso = ISO.DATE)
  private Date dateOrderShipped;

  @Column(name="date_support_expires")
	@DateTimeFormat(iso = ISO.DATE)
  private Date dateSupportExpires;

  @Column(name="date_support_starts")
	@DateTimeFormat(iso = ISO.DATE)
  private Date dateSupportStarts;

	@Column(name = "asset_number", length=15)
	private String assetNumber;

	@Column(name = "serial_number", length=15)
	private String serialNumber;

	@Column(name = "info", columnDefinition="TEXT")
	private String info;

	public InventoryDetail getEntry() {
		return entry;
	}

	public void setEntry(InventoryDetail entry) {
		this.entry = entry;
	}

	public PosTax getTaxClass() {
		return taxClass;
	}

	public void setTaxClass(PosTax taxClass) {
		this.taxClass = taxClass;
	}

	public Float getQuantity() {
		return quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getListPrice() {
		return listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}

	public BigDecimal getExtendedPrice() {
		return extendedPrice;
	}

	public void setExtendedPrice(BigDecimal extendedPrice) {
		this.extendedPrice = extendedPrice;
	}

	public String getPricingFormula() {
		return pricingFormula;
	}

	public void setPricingFormula(String pricingFormula) {
		this.pricingFormula = pricingFormula;
	}

	public Float getPricingFactor() {
		return pricingFactor;
	}

	public void setPricingFactor(Float pricingFactor) {
		this.pricingFactor = pricingFactor;
	}

	public CTAContact getSupportContact() {
		return supportContact;
	}

	public void setSupportContact(CTAContact supportContact) {
		this.supportContact = supportContact;
	}

	public String getSupportName() {
		return supportName;
	}

	public void setSupportName(String supportName) {
		this.supportName = supportName;
	}

	public String getSupportTerm() {
		return supportTerm;
	}

	public void setSupportTerm(String supportTerm) {
		this.supportTerm = supportTerm;
	}

	public String getSupportDescription() {
		return supportDescription;
	}

	public void setSupportDescription(String supportDescription) {
		this.supportDescription = supportDescription;
	}

	public Date getDateOrderShipped() {
		return dateOrderShipped;
	}

	public void setDateOrderShipped(Date dateOrderShipped) {
		this.dateOrderShipped = dateOrderShipped;
	}

	public Date getDateSupportExpires() {
		return dateSupportExpires;
	}

	public void setDateSupportExpires(Date dateSupportExpires) {
		this.dateSupportExpires = dateSupportExpires;
	}

	public Date getDateSupportStarts() {
		return dateSupportStarts;
	}

	public void setDateSupportStarts(Date dateSupportStarts) {
		this.dateSupportStarts = dateSupportStarts;
	}

	public String getAssetNumber() {
		return assetNumber;
	}

	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public BizOrder getBizOrder() {
		return bizOrder;
	}

	public void setBizOrder(BizOrder bizOrder) {
		this.bizOrder = bizOrder;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
