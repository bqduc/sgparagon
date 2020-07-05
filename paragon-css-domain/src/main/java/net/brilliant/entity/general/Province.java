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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.brilliant.framework.entity.RepoAuditable;

/**
 * Entity class Province
 * 
 * @author dumlupinar
 */
@Entity
@Table(name = "province")
public class Province extends RepoAuditable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8380311023248841621L;

	@Column(name = "plate", length = 8, nullable = false)
	private String plate;

	@Column(name = "name", length = 50)
	private String name;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Province[id=" + getId() + "]";
	}

}
