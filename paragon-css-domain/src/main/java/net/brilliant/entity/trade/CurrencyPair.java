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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.brilliant.entity.general.Currency;
import net.brilliant.framework.entity.RepoEntity;

/**
 * Entity class CurrencyPair
 * 
 * @author haky
 */
@Entity
@Table(name="CURRENCY_PAIR")
public class CurrencyPair extends RepoEntity {

    private static final long serialVersionUID = 1L;

    @Column(name="INFO")
    private String info;
    
    @ManyToOne
    @JoinColumn(name="HARD_CURRENCY_ID")
    private Currency hardCurrency;
    
    @ManyToOne
    @JoinColumn(name="WEAK_CURRENCY_ID")
    private Currency weakCurrency;
    
    @Column(name="SYSTEM")
    private Boolean system;
    
    @Column(name="ISACTIVE")
    private Boolean active = Boolean.TRUE;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Boolean getSystem() {
        return system;
    }

    public void setSystem(Boolean system) {
        this.system = system;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Currency getHardCurrency() {
        return hardCurrency;
    }

    public void setHardCurrency(Currency hardCurrency) {
        this.hardCurrency = hardCurrency;
    }

    public Currency getWeakCurrency() {
        return weakCurrency;
    }

    public void setWeakCurrency(Currency weakCurrency) {
        this.weakCurrency = weakCurrency;
    }

    @Transient
    public String getCaption(){
        return getHardCurrency().getCode() + "-" + getWeakCurrency().getCode();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "CurrencyPair[id=" + getId() + "]";
    }

}
