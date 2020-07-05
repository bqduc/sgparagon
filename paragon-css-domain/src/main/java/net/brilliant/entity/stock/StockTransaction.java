package net.brilliant.entity.stock;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import net.brilliant.framework.entity.RepoAuditable;
import net.brilliant.framework.validation.InDateRange;
import net.brilliant.global.GlobalConstants;
import net.brilliant.model.StockAction;

/**
 * 
 * @author ducbq
 * 
 */

@Entity
@Table(name = "stock_transaction")
public class StockTransaction extends RepoAuditable {
	/**
	* 
	*/
	private static final long serialVersionUID = 6091602558361527115L;

	@Size(max = GlobalConstants.SIZE_SERIAL)
	@Column(name = "serialNo", unique = true)
	private String serialNo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "date")
	@InDateRange
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Basic(optional = false)
	@Column(name = "date_end")
	@InDateRange
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateEnd;

	@Column(name = "amount_tax")
	private Double amountTax = 0d;

	@Column(name = "amount_total")
	private Double amountTotal = 0d;

	@Column(name = "amount_untaxed")
	private Double amountUntaxed = 0d;

	@Size(max = 64, message = "{LongString}")
	@Column(name = "state")
	private String state;

	@Column(name = "shipped")
	private Boolean shipped = false;

	@Column(name = "delivery_created")
	private Boolean deliveryCreated = false;

	@Column(name = "paid")
	private Boolean paid = false;

	@Column(name = "unpaid")
	private Double unpaid = 0d;

	@Lob
	@Size(max = 2147483647)
	@Column(name = "notes")
	private String notes;

	@Size(max = 64, message = "{LongString}")
	@Column(name = "invoice_method")
	private String invoiceMethod = "Partial";

	@Column(name = "discount")
	private Integer discount;

	@Size(max = 64, message = "{LongString}")
	@Column(name = "name")
	private String name;

	@Size(max = 64, message = "{LongString}")
	@Column(name = "reference")
	private String reference;

	@Column(name = "partner_id")
	private Long partnerId;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "stockTransaction", orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<StockTransactionDetail> stockTransactionDetails;

	@Column(name = "issued_user_sso_id")
	private String issuedUserSsoId;
	@Basic(optional = false)
	@NotNull
	@Column(name = "issued_date")
	@InDateRange
	@Temporal(TemporalType.TIMESTAMP)
	private Date issuedDate;

	@Column(name = "approved_user_sso_id")
	private String approvedUserSsoId;

	@Basic(optional = false)
	@NotNull
	@Column(name = "approved_date")
	@InDateRange
	@Temporal(TemporalType.TIMESTAMP)
	private Date approvedDate;

  @Column(name="stock_action")
  @Enumerated(EnumType.ORDINAL)
  private StockAction stockAction;
  
	/*
	 * @OneToMany(mappedBy = "purchaseOrder")
	 * 
	 * @LazyCollection(LazyCollectionOption.FALSE) private List<Invoice> invoices;
	 */

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getAmountTax() {
		return amountTax;
	}

	public void setAmountTax(Double amountTax) {
		this.amountTax = amountTax;
	}

	public Double getAmountTotal() {
		return amountTotal;
	}

	public void setAmountTotal(Double amountTotal) {
		this.amountTotal = amountTotal;
	}

	public Double getAmountUntaxed() {
		return amountUntaxed;
	}

	public void setAmountUntaxed(Double amountUntaxed) {
		this.amountUntaxed = amountUntaxed;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Boolean getShipped() {
		return shipped;
	}

	public void setShipped(Boolean shipped) {
		this.shipped = shipped;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public Double getUnpaid() {
		return unpaid;
	}

	public void setUnpaid(Double unpaid) {
		this.unpaid = unpaid;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getInvoiceMethod() {
		return invoiceMethod;
	}

	public void setInvoiceMethod(String invoiceMethod) {
		this.invoiceMethod = invoiceMethod;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getDeliveryCreated() {
		return deliveryCreated;
	}

	public void setDeliveryCreated(Boolean deliveryCreated) {
		this.deliveryCreated = deliveryCreated;
	}

	public Long getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public List<StockTransactionDetail> getStockTransactionDetails() {
		return stockTransactionDetails;
	}

	public void setStockTransactionDetails(List<StockTransactionDetail> stockTransactionDetails) {
		this.stockTransactionDetails = stockTransactionDetails;
		for (StockTransactionDetail stckDetail : this.stockTransactionDetails) {
			stckDetail.setStockTransaction(this);
		}
	}

	public String getIssuedUserSsoId() {
		return issuedUserSsoId;
	}

	public void setIssuedUserSsoId(String issuedUserSsoId) {
		this.issuedUserSsoId = issuedUserSsoId;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public String getApprovedUserSsoId() {
		return approvedUserSsoId;
	}

	public void setApprovedUserSsoId(String approvedUserSsoId) {
		this.approvedUserSsoId = approvedUserSsoId;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public StockAction getStockAction() {
		return stockAction;
	}

	public void setStockAction(StockAction stockAction) {
		this.stockAction = stockAction;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	@Override
	public String toString() {
		return "StockTransaction[ id=" + getId() + " ]";
	}

}
