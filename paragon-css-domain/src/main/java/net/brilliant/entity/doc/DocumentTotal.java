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

package net.brilliant.entity.doc;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

import net.brilliant.common.ListUtility;
import net.brilliant.entity.general.MoneySet;

/**
 * Fiş dip toplamlarını sağlamak için generic bir araç.
 * 
 * Money setle birlikte yapısı kolaylaştı.
 * 
 * @author haky
 */
public class DocumentTotal {

	private Map<Long, MoneySet> data = ListUtility.createMap();
	private BigDecimal localTotal = BigDecimal.ZERO;

	public void add(MoneySet amount) {
		MoneySet item = data.get(amount.getCurrency());

		if (item == null) {
			item = new MoneySet(amount);
			data.put(item.getCurrency().getId(), item);
		} else {
			item.setValue(item.getValue().add(amount.getValue()));
			item.setLocalAmount(item.getLocalAmount().add(
					amount.getLocalAmount()));
		}

		localTotal = localTotal.add(amount.getLocalAmount());
	}

	public BigDecimal getLocalTotal() {
		return localTotal;
	}

	public Map<Long, MoneySet> getTotalMap() {
		return data;
	}

	public Collection<MoneySet> getTotals() {
		return data.values();
	}
}