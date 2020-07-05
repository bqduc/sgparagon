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

package net.brilliant.entity.trade.ord;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.brilliant.entity.trade.TenderCurrencySummaryBase;
import net.brilliant.entity.trade.inv.TekirInvoiceCurrencySummary;

/**
 * @author sinan.yumak
 *
 */
@Entity
@Table(name="TEKIR_ORDER_NOTE_CURRENCY_SUMMARY")
public class TekirOrderNoteCurrencySummary extends TenderCurrencySummaryBase {

	private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name="OWNER_ID")
    private TekirOrderNote owner;
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "TekirOrderNoteCurrencySummary[id=" + getId() + "]";
    }

	public TekirOrderNote getOwner() {
		return owner;
	}

	public void setOwner(TekirOrderNote owner) {
		this.owner = owner;
	}
    
}
