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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import net.brilliant.framework.entity.RepoAuditable;
import net.brilliant.model.PaymentTableGroupModel;

/**
 * Sipariş,kaparo vb. ekranlarda cari tahsilat bilgilerini
 * tutan sınıfımızdır.
 * @author sinan.yumak
 *
 */
@Entity
@Table(name="PAYMENT_TABLE")
public class PaymentTable extends RepoAuditable {
    
	private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy="owner", cascade=CascadeType.ALL)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private List<PaymentTableDetail> detailList = new ArrayList<PaymentTableDetail>();

    public Map<PaymentTableGroupModel, BigDecimal> getAsGroupped() {
		Map<PaymentTableGroupModel, BigDecimal> result = new HashMap<PaymentTableGroupModel, BigDecimal>();
    	
		PaymentTableGroupModel model;
    	for (PaymentTableDetail item : detailList) {
			model = new PaymentTableGroupModel(item);

			if (!result.containsKey(model)) {
				result.put(model, item.getAmount().getLocalAmount());
			} else {
				result.put(model, result.get(model).add(item.getAmount().getLocalAmount()));
			}
    	}
    	return result;
    }

    @Override
    public String toString() {
        return "PaymentTable[id=" + getId() + "]";
    }

    public PaymentTable clone() {
    	/*PaymentTable clonedpt = null;
			try {
				clonedpt = (PaymentTable)CommonBeanUtils.clone(this);
			} catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
				e.printStackTrace();
			}*/
    	PaymentTable clonedpt = new PaymentTable();
    	/*clonedpt.setCreationDate(getCreationDate());
    	clonedpt.setCreatedBy(this.getCreatedBy());
    	clonedpt.setLastModified(getLastModified());
    	clonedpt.setLastModifiedBy(getLastModifiedBy());*/

    	PaymentTableDetail clonedptd = null;
    	for (PaymentTableDetail ptd : getDetailList()) {
    		clonedptd = ptd.clone();

    		clonedptd.setOwner(clonedpt);
    		clonedpt.getDetailList().add(clonedptd);
    	}
    	return clonedpt;
    }
    
	public List<PaymentTableDetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<PaymentTableDetail> detailList) {
		this.detailList = detailList;
	}

}
