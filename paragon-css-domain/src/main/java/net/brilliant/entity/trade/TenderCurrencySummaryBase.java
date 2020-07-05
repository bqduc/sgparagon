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

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

import net.brilliant.entity.general.MoneySet;
import net.brilliant.framework.entity.RepoEntity;

/**
 * Teklif, sipariş, irsaliye ve faturadaki toplam döviz tutarları
 * için ortak ara model. 
 * @author sinan.yumak
 *
 */
@MappedSuperclass
public class TenderCurrencySummaryBase extends RepoEntity {

	private static final long serialVersionUID = 1L;
	
    @Embedded
    @AttributeOverrides( {
        @AttributeOverride(name="currency", column=@Column(name="CCY", insertable=false, updatable=false)),
        @AttributeOverride(name="value",    column=@Column(name="CCYVAL")),
        @AttributeOverride(name="localAmount", column=@Column(name="LCYVAL"))
    })
    private MoneySet amount = new MoneySet();

	public MoneySet getAmount() {
		return amount;
	}

	public void setAmount(MoneySet amount) {
		this.amount = amount;
	}

}
