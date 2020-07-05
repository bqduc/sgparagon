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
import javax.persistence.Table;

import net.brilliant.framework.entity.RepoEntity;

/**
 *
 * @author sinan.yumak
 *
 */
@Entity
@Table(name = "ORGANIZATION_LEVEL")
public class OrganizationLevel extends RepoEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "NAME")
	private String name;

	@Column(name = "LEVEL")
	private Integer level;

	@Override
	public String toString() {
		return getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

}
