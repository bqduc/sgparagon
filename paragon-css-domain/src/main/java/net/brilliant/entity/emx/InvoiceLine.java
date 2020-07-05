
package net.brilliant.entity.emx;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import net.brilliant.framework.validation.StrictlyPositiveNumber;

/**
 * 
 * @author MOHAMMED BOUNAGA
 * 
 * github.com/medbounaga
 */


@Entity
@Table(name = "invoice_line")
@NamedQueries({    
    @NamedQuery(name = "InvoiceLine.findByInvoice", query = "SELECT i FROM InvoiceLine i WHERE i.invoice.id = :id"),
    @NamedQuery(name = "InvoiceLine.findAll", query = "SELECT i FROM InvoiceLine i"),
    @NamedQuery(name = "InvoiceLine.findById", query = "SELECT i FROM InvoiceLine i WHERE i.id = :id"),
    @NamedQuery(name = "InvoiceLine.findByDate", query = "SELECT i FROM InvoiceLine i WHERE i.date = :date"),
    @NamedQuery(name = "InvoiceLine.findByPrice", query = "SELECT i FROM InvoiceLine i WHERE i.price = :price"),
    @NamedQuery(name = "InvoiceLine.findByPriceSubtotal", query = "SELECT i FROM InvoiceLine i WHERE i.priceSubtotal = :priceSubtotal"),
    @NamedQuery(name = "InvoiceLine.findByDiscount", query = "SELECT i FROM InvoiceLine i WHERE i.discount = :discount"),
    @NamedQuery(name = "InvoiceLine.findByQuantity", query = "SELECT i FROM InvoiceLine i WHERE i.quantity = :quantity"),
    @NamedQuery(name = "InvoiceLine.findByActive", query = "SELECT i FROM InvoiceLine i WHERE i.active = :active"),
    @NamedQuery(name = "InvoiceLine.findByUom", query = "SELECT i FROM InvoiceLine i WHERE i.uom = :uom")
})
public class InvoiceLine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 128, message = "{LongString}")
    @Column(name = "name")
    private String name;
    @Size(max = 40, message = "{LongString}")
    @Column(name = "uom")
    private String uom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price_subtotal")
    private double priceSubtotal;
    @Basic(optional = false)
    @Max(value=100, message="{MaxDiscount}") 
    @Min(value=0,  message = "{PositiveDiscount}") 
    @NotNull
    @Column(name = "discount")
    private Double discount = 0d;
    @Basic(optional = false)
    @NotNull
    @StrictlyPositiveNumber(message = "{PositiveQuantity}")
    @Column(name = "quantity")
    private Double quantity = 1d;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private Boolean active;
    @Transient
    private String productName;
    @Transient
    private String taxName;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EnterpriseAccount account;
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CustomerInvoice invoice;
    @JoinColumn(name = "partner_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Partner partner;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne
    private EnterpriseProduct product;
    @JoinColumn(name = "tax_id", referencedColumnName = "id")
    @ManyToOne
    private EnterpriseTax tax;

    public InvoiceLine() {
    }

    public InvoiceLine(Integer id) {
        this.id = id;
    }

    public InvoiceLine(Date date, String uom, double price, double priceSubtotal, Double discount, Double quantity, Boolean active, CustomerInvoice invoice, Partner partner, EnterpriseProduct product, EnterpriseTax tax, EnterpriseAccount account) {
        this.date = date;
        this.uom = uom;
        this.price = price;
        this.priceSubtotal = priceSubtotal;
        this.discount = discount;
        this.quantity = quantity;
        this.active = active;
        this.invoice = invoice;
        this.partner = partner;
        this.product = product;
        this.tax = tax;
        this.account = account;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceSubtotal() {
        return priceSubtotal;
    }

    public void setPriceSubtotal(double priceSubtotal) {
        this.priceSubtotal = priceSubtotal;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public EnterpriseAccount getAccount() {
        return account;
    }

    public void setAccount(EnterpriseAccount account) {
        this.account = account;
    }

    public CustomerInvoice getInvoice() {
        return invoice;
    }

    public void setInvoice(CustomerInvoice invoice) {
        this.invoice = invoice;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public EnterpriseProduct getProduct() {
        return product;
    }

    public void setProduct(EnterpriseProduct product) {
        this.product = product;
    }

    public EnterpriseTax getTax() {
        return tax;
    }

    public void setTax(EnterpriseTax tax) {
        this.tax = tax;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceLine)) {
            return false;
        }
        InvoiceLine other = (InvoiceLine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InvoiceLine[ id=" + id + " ]";
    }
    
}
