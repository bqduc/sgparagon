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

package net.brilliant.entity.general;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import net.brilliant.framework.entity.RepoAuditable;

/**
 * Entity class Country
 * 
 * @author haky
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "country")
public class Country extends RepoAuditable {
	private static final long serialVersionUID = -8233303460213700583L;

	@Column(name = "code", nullable = false, unique = true, length = 2)
	private String code;

	@Column(name = "iso_code", nullable = false, unique = true, length = 3)
	private String isoCode;

	@Column(name = "iso_language_code", length = 2)
	private String isoLanguageCode;

	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "name_local", length = 50)
	private String nameLocal;

	@Lob
	@Column(name = "info", columnDefinition="TEXT")
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

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public String getNameLocal() {
		return nameLocal;
	}

	public void setNameLocal(String nameLocal) {
		this.nameLocal = nameLocal;
	}

	public String getIsoLanguageCode() {
		return isoLanguageCode;
	}

	public void setIsoLanguageCode(String isoLanguageCode) {
		this.isoLanguageCode = isoLanguageCode;
	}
}
