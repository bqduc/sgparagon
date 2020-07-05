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
import javax.validation.Valid;

import net.brilliant.entity.general.Money;
import net.brilliant.entity.general.MoneySet;
import net.brilliant.entity.general.Quantity;
import net.brilliant.entity.stock.InventoryDetail;
import net.brilliant.framework.entity.RepoEntity;

/**
 * Entity class ShipmentItem
 * 
 * Satır üzerinde girilen büyün indirimler masraflar ve vergilerin sonucu total'a konur.
 * Local Amount Total'ın ocal karşılığıdır.
 * ʩndirim ve Masraflarn dövizi satr tipindedir.
 * 
 * @author haky
 */
@Entity
@Table(name="SHIPMENT_ITEM")
public class ShipmentItem extends RepoEntity implements InvoiceItem {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name="OWNER_ID")
    private ShipmentNote owner;
    
    @ManyToOne
    @JoinColumn(name="PRODUCT_ID")
    private InventoryDetail product;
    
    @Column(name="INFO")
    private String info;
    
    @Column(name="LINE_CODE", length=10)
    private String lineCode;
    
    @Embedded
    @Valid
    private Quantity quantity = new Quantity();
    
    @Embedded
    @Valid
    @AttributeOverrides( {
        @AttributeOverride(name="currency", column=@Column(name="PRICE_CCY")),
        @AttributeOverride(name="value",    column=@Column(name="PRICE_VALUE")),
        @AttributeOverride(name="localAmount", column=@Column(name="PRICE_LCYVAL"))
    })
    private MoneySet unitPrice = new MoneySet();
    
    @Embedded
    @Valid
    @AttributeOverrides( {
        @AttributeOverride(name="currency",    column=@Column(name="AMOUNT_CCY")),
        @AttributeOverride(name="value",       column=@Column(name="AMOUNT_VALUE")),
        @AttributeOverride(name="localAmount", column=@Column(name="AMOUNT_LCYVAL"))
    })
    private MoneySet amount = new MoneySet();
    
    @Column(name="TAX_RATE", precision=10, scale=2)
    private BigDecimal taxRate = BigDecimal.ZERO;
    
    @Embedded
    @Valid
    @AttributeOverrides( {
        @AttributeOverride(name="currency",    column=@Column(name="TAX_CCY")),
        @AttributeOverride(name="value",       column=@Column(name="TAX_VALUE")),
        @AttributeOverride(name="localAmount", column=@Column(name="TAX_LCYVAL"))
    })
    private MoneySet taxAmount = new MoneySet(); 
    
    @Embedded
    @Valid
    @AttributeOverrides( {
        @AttributeOverride(name="currency",    column=@Column(name="TOTAL_CCY")),
        @AttributeOverride(name="value",       column=@Column(name="TOTAL_VALUE")),
        @AttributeOverride(name="localAmount", column=@Column(name="TOTAL_LCYVAL"))
    })
    private Money totalAmount = new Money(); 
    
    @Embedded
    @Valid
    @AttributeOverrides( {
        @AttributeOverride(name="currency",    column=@Column(name="TAX_EXC_TOTAL_CCY")),
        @AttributeOverride(name="value",       column=@Column(name="TAX_EXC_TOTAL_VALUE")),
        @AttributeOverride(name="localAmount", column=@Column(name="TAX_EXC_TOTAL_LCYVAL"))
    })
    private MoneySet taxExcludedTotalAmount = new MoneySet();
    
    @Column(name="LINE_DISCOUNT", precision=10, scale=2)
    private BigDecimal lineDiscount = BigDecimal.ZERO;
    
    @Column(name="SHIPMENT_DISCOUNT", precision=10, scale=2)
    private BigDecimal shipmentDiscount = BigDecimal.ZERO;
    
    @Column(name="INVOICE_DISCOUNT", precision=10, scale=2)
    private BigDecimal invoiceDiscount = BigDecimal.ZERO;
    
    @Column(name="LINE_EXPENSE", precision=10, scale=2)
    private BigDecimal lineExpense = BigDecimal.ZERO;
    
    @Column(name="SHIPMENT_EXPENSE", precision=10, scale=2)
    private BigDecimal shipmentExpense = BigDecimal.ZERO;
    
    @Column(name="INVOICE_EXPENSE", precision=10, scale=2)
    private BigDecimal invoiceExpense = BigDecimal.ZERO;
    
    @Column(name="ORDER_ITEMID")
    private Long orderItemId;

    public ShipmentNote getOwner() {
        return owner;
    }

    public void setOwner(ShipmentNote owner) {
        this.owner = owner;
    }

    public InventoryDetail getProduct() {
        return product;
    }

    public void setProduct(InventoryDetail product) {
        this.product = product;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public MoneySet getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(MoneySet unitPrice) {
        this.unitPrice = unitPrice;
    }

    public MoneySet getAmount() {
        return amount;
    }

    public void setAmount(MoneySet amount) {
        this.amount = amount;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public MoneySet getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(MoneySet taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getLineDiscount() {
        return lineDiscount;
    }

    public void setLineDiscount(BigDecimal lineDiscount) {
        this.lineDiscount = lineDiscount;
    }

    public BigDecimal getShipmentDiscount() {
        return shipmentDiscount;
    }

    public void setShipmentDiscount(BigDecimal shipmentDiscount) {
        this.shipmentDiscount = shipmentDiscount;
    }

    public BigDecimal getInvoiceDiscount() {
        return invoiceDiscount;
    }

    public void setInvoiceDiscount(BigDecimal invoiceDiscount) {
        this.invoiceDiscount = invoiceDiscount;
    }

    public BigDecimal getLineExpense() {
        return lineExpense;
    }

    public void setLineExpense(BigDecimal lineExpense) {
        this.lineExpense = lineExpense;
    }

    public BigDecimal getShipmentExpense() {
        return shipmentExpense;
    }

    public void setShipmentExpense(BigDecimal shipmentExpense) {
        this.shipmentExpense = shipmentExpense;
    }

    public BigDecimal getInvoiceExpense() {
        return invoiceExpense;
    }

    public void setInvoiceExpense(BigDecimal invoiceExpense) {
        this.invoiceExpense = invoiceExpense;
    }

    public String getName() {
        return product.toString();
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "ShipmentItem[id=" + getId() + "]";
    }

	/**
	 * @return the orderItemId
	 */
	public Long getOrderItemId() {
		return orderItemId;
	}

	/**
	 * @param orderItemId the orderItemId to set
	 */
	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public void setTotalAmount(Money totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Money getTotalAmount() {
		return totalAmount;
	}

	public MoneySet getTaxExcludedTotalAmount() {
		return taxExcludedTotalAmount;
	}

	public void setTaxExcludedTotalAmount(MoneySet taxExcludedTotalAmount) {
		this.taxExcludedTotalAmount = taxExcludedTotalAmount;
	}


}
