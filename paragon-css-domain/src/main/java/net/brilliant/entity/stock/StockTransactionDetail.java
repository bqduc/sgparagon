
package net.brilliant.entity.stock;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import net.brilliant.entity.contact.CTAContact;
import net.brilliant.entity.trade.Tax;
import net.brilliant.framework.entity.RepoEntity;
import net.brilliant.framework.validation.StrictlyPositiveNumber;

/**
 * 
 * @author ducbq
 * 
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "stock_transaction_detail")
public class StockTransactionDetail extends RepoEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7704151060345281991L;

	//Will different with date value from transaction in case the real inventory performed different date
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Builder.Default
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigDecimal price = BigDecimal.ZERO;

    @Builder.Default
    @Basic(optional = false)
    @NotNull
    @StrictlyPositiveNumber(message = "{PositiveQuantity}")
    @Column(name = "quantity")
    private Double quantity = 1d;

    @Size(max = 64, message = "{LongString}")
    @Column(name = "state")
    private String state;

    @Size(max = 40, message = "{LongString}")
    @Column(name = "uom")
    private String uom;
    
    @Builder.Default
    @Basic(optional = false)
    @NotNull
    @Column(name = "sub_total")
    private BigDecimal subTotal = BigDecimal.ZERO;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private Boolean active;
    
    @NotNull
    @Column(name = "invoiced")
    private Boolean invoiced;

    @Transient
    private String productName;

    @Transient
    private String taxName;

    @JoinColumn(name = "stock_transaction_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StockTransaction stockTransaction;

    @JoinColumn(name = "inventory_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InventoryItem inventoryItem;

    @JoinColumn(name = "tax_id", referencedColumnName = "id")
    @ManyToOne
    private Tax tax;

    @JoinColumn(name = "vendor_id", referencedColumnName = "id")
    @ManyToOne
    private CTAContact vendor;

    @Size(max = 100, message = "{LongString}")
    @Column(name = "info")
    private String info;

    @Builder.Default
    @Column(name = "sales_rate")
    private BigDecimal salesRate = BigDecimal.ZERO;//Giá bán 

    @Builder.Default
    @Column(name = "purchase_rate")
    private BigDecimal purchaseRate = BigDecimal.ZERO;//Giá mua 

    @Builder.Default
    @Column(name = "cost_of_goods_sold")
    private BigDecimal costOfGoodsSold  = BigDecimal.ZERO;//Giá vốn bán hàng

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
    
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public Boolean getInvoiced() {
        return invoiced;
    }

    public void setInvoiced(Boolean invoiced) {
        this.invoiced = invoiced;
    }

    @Override
    public String toString() {
        return "StockTransactionDetail[id=" + getId() + " ]";
    }

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public StockTransaction getStockTransaction() {
			return stockTransaction;
		}

		public void setStockTransaction(StockTransaction stockTransaction) {
			this.stockTransaction = stockTransaction;
		}

		public InventoryItem getInventoryItem() {
			return inventoryItem;
		}

		public void setInventoryItem(InventoryItem inventoryItem) {
			this.inventoryItem = inventoryItem;
		}

		public Tax getTax() {
			return tax;
		}

		public void setTax(Tax tax) {
			this.tax = tax;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}

		public CTAContact getVendor() {
			return vendor;
		}

		public void setVendor(CTAContact vendor) {
			this.vendor = vendor;
		}
    
}
