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

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.brilliant.common.ListUtility;
import net.brilliant.domain.entity.general.Catalogue;
import net.brilliant.entity.contact.ContactCore;
import net.brilliant.entity.general.BusinessUnit;
import net.brilliant.entity.general.Department;
import net.brilliant.entity.general.MeasureUnit;
import net.brilliant.entity.imx.PrinterGroup;
import net.brilliant.entity.trade.ExpenseType;
import net.brilliant.entity.trade.Foundation;
import net.brilliant.entity.trade.PaymentActionType;
import net.brilliant.framework.entity.RepoAuditable;
import net.brilliant.global.GlobalConstants;
import net.brilliant.model.BindingType;
import net.brilliant.model.DustJacketType;
import net.brilliant.model.InventoryType;

/**
 * Entity class Product
 * 
 * @author ducbq
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "inventory_detail")
@EqualsAndHashCode(callSuper=false)
public class InventoryDetail extends RepoAuditable {
	private static final long serialVersionUID = -2929178651788000055L;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private InventoryCore owner;

	@Builder.Default
	@Column(name = "PRODUCT_TYPE")
	@Enumerated(EnumType.ORDINAL)
	private ProductType productType = ProductType.Product;

	@Basic(fetch = FetchType.LAZY)
	@Lob
	@Column(name = "image_default")
	@Type(type = "org.hibernate.type.ImageType")
	private byte[] imageDefault;

	@ManyToOne
	@JoinColumn(name = "ExpenseType_ID")
	private ExpenseType expenseType;

	@Builder.Default
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductUnit> productUnitList = new ArrayList<ProductUnit>();

	@Builder.Default
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<InventoryPrice> productProfileDiscountList = ListUtility.createList();

	@Builder.Default
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductProfileTax> productProfileTaxList = ListUtility.createList();

	@Builder.Default
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<InventoryCategory> productProfileCategoryList = ListUtility.createList();
	
	@Builder.Default
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<InventoryImage> productImageList = ListUtility.createList();

	@Builder.Default
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductProfilePartner> productProfilePartnerList = ListUtility.createList();

	/**
	 * The institution keeps its information.
	 */
	@ManyToOne
	@JoinColumn(name = "foundation_id")
	private Foundation foundation;

	@ManyToOne
	@JoinColumn(name = "payment_action_type_id")
	private PaymentActionType paymentActionType;

	/**
	 * Katkı masraf veya indirimlerinin yansıtılacağı hizmeti tutar.
	 */
	@ManyToOne
	@JoinColumn(name = "REF_PRODUCT_ID", foreignKey = @ForeignKey(name = "FK_PRODUCT_REFERENCEPRODUCTID"))
	private InventoryDetail referenceProduct;

	@ManyToOne
	@JoinColumn(name = "active_ingredient_catalogue_id", foreignKey = @ForeignKey(name = "FK_active_ingredient"))
	private Catalogue activeIngredient;

	@ManyToOne
	@JoinColumn(name = "usage_direction_catalpogue_id", foreignKey = @ForeignKey(name = "fk_usage_direction"))
	private Catalogue usageDirection;

	@ManyToOne
	@JoinColumn(name = "servicing_business_unit_id", foreignKey = @ForeignKey(name = "fk_servicing_business_unit_id"))
	private BusinessUnit servicingBusinessUnit;

	@Column(name = "composition", length = 150)
	private String composition; // Content also

	@Column(name = "processing_type", length = 100)
	private String processingType;

	@Column(name = "packaging", length = 150)
	private String packaging;

	@Column(name = "info", columnDefinition = "TEXT")
	private String info;

	@Column(name = "manufacturing_date")
	private Date manufacturingDate;

	@Column(name = "available_date")
	private Date availableDate;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private InventoryDetail parent;

	@Column(name = "government_decision_no", length = GlobalConstants.SIZE_SERIAL)
	private String governmentDecisionNo;

	@Column(name = "circular_no")
	private String nationalCircularNo;

	@Column(name = "published_code", length = GlobalConstants.SIZE_SERIAL)
	private String publishedCode;

	@Column(name = "standard", length = 50)
	private String standard;

	@Column(name = "expectation_of_life", length = 50)
	private String expectationOfLife;

	@Column(name = "root")
	private String root;

	@Column(name = "maintenance_level")
	private String maintenanceLevel;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "issue_date")
	private Date issueDate;

	@Builder.Default
	@Column(name = "reset_date")
	private ZonedDateTime resetDate = null;

	@Builder.Default
	@Column(name = "weight")
	private Double weight = 0d;

	@Builder.Default
	@Column(name = "volume")
	private Double volume = 0d;

	@Builder.Default
	@Column(name = "lenght")
	private Double length = 0d;

	@Column(name = "sale_ok")
	private Boolean saleOk;

	@Column(name = "purchase_ok")
	private Boolean purchaseOk;

	@ManyToOne
	@JoinColumn(name = "measure_unit_id")
	private MeasureUnit measureUnit;
	
	@Column(name = "external_code", length=GlobalConstants.SIZE_CODE)
	private String externalCode;

	@Column(name = "external_type", length=GlobalConstants.SIZE_STRING_TINY)
	private String externalType;

	@Column(name="active_principle", length=150)
	private String activePrinciple;	
	
	@Column(name = "binding_type")
	@Enumerated(EnumType.ORDINAL)
	private BindingType bindingType;

	@Column(name = "inventory_type")
	@Enumerated(EnumType.ORDINAL)
	private InventoryType inventoryType;

	@Column(name = "fulfillment_center_id", length = 40)
	private String fulfillmentCenterId;

	@Column(name = "sku", length = 40)
	private String sku;

	@Column(name = "dust_jacket_type")
	@Enumerated(EnumType.ORDINAL)
	private DustJacketType dustJacketType;

	@Column(name = "signed_by", length = 40)
	private String signedBy;

  /**
   * Select the option corresponding to your choice: "y" if you are offering expedited shipping to your customers; "n" otherwise.
   * 
   * "n" = Expedited shipping not available	
   * "y" = Expedited shipping available"
   */
	@Column(name = "expedited_shipping", length=2)
	private String expeditedShipping;

  /**
   * Select the code corresponding to your choice: "1" or "n": Will ship within US only; "2" or "y": Will ship to international locations
   * 
   * "1" or "n" = Will ship in US only
   * "2" or "y" = Will ship to international locations
   */
	@Column(name = "will_ship_internationally", length=2)
	private String willShipInternationally;
  
	@Column(name = "condition", columnDefinition="TEXT")
	private String condition;

	@ManyToOne
	@JoinColumn(name = "sub_category_id")
	private Catalogue subCategory;

	@ManyToOne
	@JoinColumn(name = "supplementary_category_id")
	private Catalogue supplementaryCategory;

	@ManyToOne
	@JoinColumn(name = "extra_category_id")
	private Catalogue extraCategory;

	@ManyToOne
	@JoinColumn(name = "business_group_id")
	private Department businessGroup;

	@Column(name = "online_series", length=20)
	private String 	onlineSeries;

	@Column(name = "sales_model_subscription", length=20)
	private String salesModelSubscription;

	@Column(name = "sales_model_one_time", length=20)
	private String salesModelOneTime;

	@Column(name = "capacity")
	private Double capacity;

	@Column(name = "online_availability_date")
	private Date onlineAvailabilityDate;

	@Column(name = "production_publication_date")
	private Date productionPublicationDate;

	@ManyToOne
	@JoinColumn(name = "imprint_contact_id")
	private ContactCore imprint;

	@Column(name="concentration", length=150)
	private String concentration;

	@Column(name="disable_when_stock_amount_is_zero")
	private Boolean disableWhenStockAmountIsZero;

	@Column(name="sort_order")
	private Integer sortOrder;

	@Column(name="fractional_unit")
	private Boolean fractionalUnit;

	@Column(name="default_sell_portion")
	private Integer defaultSellPortion;

	@ManyToOne(targetEntity=PrinterGroup.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "printer_group_id")
	private PrinterGroup printerGroup;

	@ManyToOne
	@JoinColumn(name = "master_generic_chemical")
	private Catalogue masterGenericChemical; //Generic drug/Chemical Name//Hoạt chất

	public InventoryPrice getJITProductProfileDetail() {
		if (!this.productProfileDiscountList.isEmpty())
			return this.productProfileDiscountList.get(0);

		return InventoryPrice.builder().build();
	}

	public ProductProfileTax getJITProductProfileTax() {
		if (!this.productProfileTaxList.isEmpty())
			return this.productProfileTaxList.get(0);

		return ProductProfileTax.builder().build();
	}
}
