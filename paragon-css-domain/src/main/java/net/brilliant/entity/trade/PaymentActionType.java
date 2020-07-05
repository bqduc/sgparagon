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

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import net.brilliant.framework.entity.RepoAuditable;

/**
 * Ödeme Hareket Tip Tanımları
 * 
 * @author volkan
 *
 */
@Entity
@Table(name="PAYMENT_ACTION_TYPE")
public class PaymentActionType extends RepoAuditable implements Serializable {

	private static final long serialVersionUID = 1L;

    @Column(name="CODE", length=20, unique=true, nullable=false)
    @Size(max=20, min=1)
    @NotNull
	private String code;

    @Column(name="NAME", length=50)
    @Size(max=50)
    private String name;

    @Column(name="INFO")
	private String info;

    @Column(name="WEIGHT")
    private Integer weight ;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

	@Override
    public String toString() {
        return "PaymentActionType[id=" + getId() + "]";
    }

   	
}
