package net.brilliant.entity.general;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.brilliant.framework.entity.RepoAuditable;

/**
 * A city-postal code.
 */
@Builder
@NoArgsConstructor 
@AllArgsConstructor
@Entity
@Table(name = "city_postal_code")
@EqualsAndHashCode(callSuper=false)
public class CityPostalCode extends RepoAuditable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4210964082280924912L;

	@Column(name = "postal_code", nullable = false, length=5)
	private String postalCode;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
}
