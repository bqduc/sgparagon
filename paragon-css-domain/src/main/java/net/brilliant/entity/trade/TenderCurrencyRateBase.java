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

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import net.brilliant.framework.entity.RepoEntity;

/**
 * Teklif, sipariş, irsaliye ve faturadaki döviz oranları için
 * ortak ara model. 
 * @author sinan.yumak
 *
 */
@MappedSuperclass
public class TenderCurrencyRateBase extends RepoEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne
    @JoinColumn(name="CURRENCY_PAIR_ID")
    private CurrencyPair currencyPair;

    @Column(name="BID", precision=10, scale=4)
    private BigDecimal bid = BigDecimal.ZERO;
    
    @Column(name="ASK", precision=10, scale=4)
    private BigDecimal ask = BigDecimal.ZERO;
    
    public CurrencyPair getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(CurrencyPair currencyPair) {
		this.currencyPair = currencyPair;
	}

	public BigDecimal getBid() {
		return bid;
	}

	public void setBid(BigDecimal bid) {
		this.bid = bid;
	}

	public BigDecimal getAsk() {
		return ask;
	}

	public void setAsk(BigDecimal ask) {
		this.ask = ask;
	}

}
