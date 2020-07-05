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

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import net.brilliant.model.PaymentType;

/**
 * Cheque
 * 
 * @author dumlupinar
 */
@Entity
@DiscriminatorValue("1")
public class PaymentItemCheque extends PaymentItem {

    private static final long serialVersionUID = 1L;
        
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="CHEQUE_ID")
	private Cheque cheque;

	
	public PaymentItemCheque() {
		super();
		setLineType(PaymentType.Cheque);
	}

	@Override
	public boolean isCheque() {
		return true;
	}

	@Override
	public boolean isClientCheque() {
		return cheque != null ? cheque.getClientCheque() : false;
	}

    public Cheque getCheque() {
		return cheque;
	}

	public void setCheque(Cheque cheque) {
		this.cheque = cheque;
	}

    @Override
    public String toString() {
        return "PaymentItemCheque[id=" + getId() + "]";
    }

}
