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

import net.brilliant.entity.trade.ord.TekirOrderNote;
import net.brilliant.entity.trade.shp.TekirShipmentNote;
import net.brilliant.framework.entity.RepoEntity;

/**
 * İrsaliyenin bağlı olduğu siparişleri ve siparişlerin bağlı olduğu irsaliyeleri tutan model sınıfımızdır.
 * 
 * @author sinan.yumak
 *
 */
@Entity
@Table(name = "ORDER_SHIPMENT_LINK")
public class OrderShipmentLink extends RepoEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "ORDER_NOTE_ID")
	private TekirOrderNote orderNote;

	@ManyToOne
	@JoinColumn(name = "SHIPMENT_NOTE_ID")
	private TekirShipmentNote shipmentNote;

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.getId() != null ? this.getId().hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		return "OrderShipmentLink[id=" + getId() + "]";
	}

	public TekirOrderNote getOrderNote() {
		return orderNote;
	}

	public void setOrderNote(TekirOrderNote orderNote) {
		this.orderNote = orderNote;
	}

	public TekirShipmentNote getShipmentNote() {
		return shipmentNote;
	}

	public void setShipmentNote(TekirShipmentNote shipmentNote) {
		this.shipmentNote = shipmentNote;
	}

}
