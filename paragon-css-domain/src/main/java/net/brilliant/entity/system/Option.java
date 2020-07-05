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

package net.brilliant.entity.system;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.brilliant.framework.entity.RepoEntity;

/**
 * Uygulama için tanımlanmış olan seçeneklerin kullanıcı ya da sistem için değerlerini saklar.
 * 
 * @author haky
 */
@Entity
@Table(name = "option")
public class Option extends RepoEntity {
	/**
	* 
	*/
	private static final long serialVersionUID = 7430700338672575850L;

	@Column(name = "user_name", length = 20)
	private String user;

	@Column(name = "op_key", length = 200)
	private String key;

	@Column(name = "op_value")
	private String value;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Transient
	public String getAsString() {
		return value;
	}

	public void setAsString(String val) {
		value = val;
	}

	@Transient
	public Integer getAsInteger() {
		return Integer.parseInt(value);
	}

	public void setAsInteger(Integer val) {
		value = val.toString();
	}

	@Transient
	@SuppressWarnings("deprecation")
	public Date getAsDate() {
		return new Date(value);
	}

	public void setAsDate(Date val) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		value = sdf.format(val);
	}

	@Transient
	public Boolean getAsBoolean() {
		return Boolean.parseBoolean(value);
	}

	public void setAsBoolean(Boolean bool) {
		value = bool.toString();
	}

	@Transient
	public BigDecimal getAsBigDecimal() {
		return new BigDecimal(value);
	}

	public void setAsBigDecimal(BigDecimal aValue) {
		// TODO:scale i 2 mi almalı parametreye mi bağlamalı?
		value = aValue.setScale(2, RoundingMode.HALF_UP).toString();
	}

	/**
	 * İstenen enuma çevirme işlemlerini yapar.
	 * 
	 * @param enumClazz,
	 *          hedef enum tipi
	 * @return enum, çevirimi yapılmış enum.
	 */
	@SuppressWarnings("unchecked")
	@Transient
	public <T extends Enum> T getAsEnum(Class<T> enumClazz) {

		T o = null;
		try {
			o = (T) Enum.valueOf(enumClazz, value);
		} catch (Exception e) {
			// verilen değer enumeration içerisinde olmadığından
			// null dönecektir.
		}
		return o;
	}

	@SuppressWarnings("unchecked")
	public void setAsEnum(Enum enumVal) {
		value = enumVal.name();
	}

	@Override
	public String toString() {
		return "Option[id=" + getId() + "]";
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *          the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

}
