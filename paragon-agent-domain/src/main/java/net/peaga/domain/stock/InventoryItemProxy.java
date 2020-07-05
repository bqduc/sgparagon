package net.peaga.domain.stock;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.peaga.domain.base.Repository;

/**
 * A Book.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class InventoryItemProxy extends Repository {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1404942727416601799L;
	
	private String productType;
	private String code;
	private String barcode;
	private String name;
	private String labelName;
	private String translatedName;
	private Date openDate;
	private String info;
	private Long parentId;
	private Date issueDate;
	private Date resetDate;
	private Double weight;
	private Double volume;
	private Double length;
	private Boolean saleOk;
	private Boolean purchaseOk;
	private Long measureUnitId;
	private String inventoryType;
	private Double stockAmount;
	private Boolean disableWhenStockAmountIsZero;
	private Integer sortOrder;
	private Boolean fractionalUnit;
	private Integer defaultSellPortion;
	private BigDecimal purchasePrice;
	private BigDecimal salesPrice;
	private BigDecimal priceWithoutTax;
	private String categoryCode;
	private String taxCode;
	private String printerGroupCode;
	private List<String> servicingOrderTypeCodes;
	private List<String> modifierGroupCodes;
	private Map<String, Object> priceByParticularOrder;

	protected java.lang.String description;
	protected java.lang.String unitName;
	protected java.lang.Double buyPrice;
	protected java.lang.Double price;
	protected java.lang.Double discountRate;
	protected java.lang.Boolean visible;
	protected java.lang.Integer buttonColorCode;
	protected java.lang.Integer textColorCode;
	protected byte[] imageData;
	protected java.lang.Boolean showImageOnly;
	protected java.lang.Boolean pizzaType;

	// many to one
	private Long taxGroupId;
	private Long recepieId;

	// collections
	private java.util.List<Long> pizzaPriceIdList;
	private java.util.List<Long> shiftIds;
	private java.util.List<Long> discountIds;
	private java.util.List<Long> terminalIds;
	private java.util.Map<String, String> properties;
	private java.util.List<Long> orderTypeIdList;
}
