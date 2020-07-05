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

package net.brilliant.entity.trade.shp;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.brilliant.entity.trade.TenderCurrencySummaryBase;

/**
 * @author sinan.yumak
 *
 */
@Entity
@Table(name="TEKIR_SHIPMENT_NOTE_CURRENCY_SUMMARY")
public class TekirShipmentNoteCurrencySummary extends TenderCurrencySummaryBase {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name="OWNER_ID")
    private TekirShipmentNote owner;
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "TekirShipmentNoteCurrencySummary[id=" + getId() + "]";
    }

	public TekirShipmentNote getOwner() {
		return owner;
	}

	public void setOwner(TekirShipmentNote owner) {
		this.owner = owner;
	}

}
