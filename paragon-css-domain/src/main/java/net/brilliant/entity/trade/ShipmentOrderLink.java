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

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.brilliant.framework.entity.RepoEntity;
/**
 * Sipariş ile irsaliye arasında bağ oluşturur. 
 * 
 * Sipariş ve İrsaliy earasında ki bağ many-to-many'dir 
 * ama JPA seviyesinde yapmak yerine tek yönlü olarak irsaliye ürerinden bağlıyoruz... 
 * 
 * @author haky
 *
 */
@Entity
@Table(name="SHIPMENT_ORDER_LINK")
public class ShipmentOrderLink extends RepoEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="SHIPMENT_NOTE_ID")
	private ShipmentNote shipmentNote;
	
	@ManyToOne
	@JoinColumn(name="ORDER_NOTE_ID")
	private OrderNote orderNote;

	public ShipmentNote getShipmentNote() {
		return shipmentNote;
	}

	public void setShipmentNote(ShipmentNote shipmentNote) {
		this.shipmentNote = shipmentNote;
	}

	public OrderNote getOrderNote() {
		return orderNote;
	}

	public void setOrderNote(OrderNote orderNote) {
		this.orderNote = orderNote;
	}

    @Override
    public String toString() {
        return "com.ut.tekir.entities.ShipmentOrderLink[id=" + getId() + "]";
    }

}
