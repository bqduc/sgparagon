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
import javax.persistence.Table;
import javax.persistence.Transient;

import net.brilliant.framework.entity.RepoEntity;

/**
 * 
 * @author ducbq
 *
 */

@Entity
@Table(name="EXPENSE_TYPE")
public class ExpenseType extends RepoEntity {

	private static final long serialVersionUID = 1L;
	
    @Column(name="CODE", length=20, unique=true, nullable=false)
	private String code;

    @Column(name="NAME", length=50)
    private String name;
    
    @Column(name="INFO")
	private String info;
    
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

	@Override
	public String toString() {
		return "ExpenseType[id=" + getId() + "]";
	}
	
	/**
	 * ExpenseType popuptan gelen degeri kullanan converter icin gerekli
	 * @see ExpenseTypeCaptionConverter
	 */
	@Transient
	public String getCaption(){
	    return "[" + getCode() + "] " + getName();
	}

}
