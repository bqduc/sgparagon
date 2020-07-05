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

package net.brilliant.entity.stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.brilliant.framework.entity.RepoEntity;

/**
 * Ürün/hizmet için stok grubu bilgisini tutan sınıfımızdır. (Bilim optik için marka bilgisini tutuyor olacak.)
 * 
 * @author sinan.yumak
 */
@Entity
@Table(name = "PRODUCT_GROUP")
public class ProductGroup extends RepoEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "CODE")
	private String code;

	@Column(name = "NAME")
	private String name;

	@Column(name = "INFO")
	private String info;

	@Column(name = "IS_ACTIVE")
	private Boolean active = Boolean.TRUE;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "ProductGroup[id=" + getId() + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
