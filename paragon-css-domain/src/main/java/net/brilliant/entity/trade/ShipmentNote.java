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

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import net.brilliant.entity.contact.CTAContact;
import net.brilliant.entity.doc.DocumentBase;
import net.brilliant.entity.doc.DocumentType;
import net.brilliant.entity.emx.CustomerInvoice;
import net.brilliant.entity.stock.Warehouse;

/**
 * Entity class ShipmentNote
 * 
 * @author haky
 */
@Entity
@Table(name="SHIPMENT_NOTE")
public class ShipmentNote extends DocumentBase {
    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    @JoinColumn(name="CONTACT_ID")
    private CTAContact contact;
    
    @ManyToOne
    @JoinColumn(name="WAREHOUSE_ID")
    private Warehouse warehouse;
    
    
    @OneToMany(mappedBy="owner", cascade=CascadeType.ALL)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private List<ShipmentItem> items = new ArrayList<ShipmentItem>();
    
    @OneToMany(mappedBy="shipmentNote", cascade=CascadeType.ALL)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private List<ShipmentOrderLink> orderLinks = new ArrayList<ShipmentOrderLink>();
    
    @ManyToOne
    @JoinColumn(name="INVOICE_ID")
    private CustomerInvoice invoice;
    
    @Column(name="TRADE_ACTION")
    @Enumerated(EnumType.ORDINAL)
    private TradeAction action;
    
    @Column(name="WRITE_INVOICE")
    private Boolean writeInvoice = Boolean.TRUE;

    @Override
	public DocumentType getDocumentType() {
		return action.equals(TradeAction.Purchase) ? DocumentType.PurchaseShipmentNote : DocumentType.SaleShipmentNote;
	}

    public CTAContact getContact() {
        return contact;
    }

    public void setContact(CTAContact contact) {
        this.contact = contact;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

	public List<ShipmentItem> getItems() {
        return items;
    }

    public void setItems(List<ShipmentItem> items) {
        this.items = items;
    }

    public CustomerInvoice getInvoice() {
        return invoice;
    }

    public void setInvoice(CustomerInvoice invoice) {
        this.invoice = invoice;
    }

    public TradeAction getAction() {
        return action;
    }

    public void setAction(TradeAction action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "com.ut.tekir.entities.ShipmentNote[id=" + getId() + "]";
    }

	/**
	 * @return the orderLinks
	 */
	public List<ShipmentOrderLink> getOrderLinks() {
		return orderLinks;
	}

	/**
	 * @param orderLinks the orderLinks to set
	 */
	public void setOrderLinks(List<ShipmentOrderLink> orderLinks) {
		this.orderLinks = orderLinks;
	}

	public Boolean getWriteInvoice() {
		return writeInvoice;
	}

	public void setWriteInvoice(Boolean writeInvoice) {
		this.writeInvoice = writeInvoice;
	}
    
}
