/**
 * 
 */
package net.peaga.domain.agricultural;

import net.peaga.domain.base.Repository;

/**
 * Food of shrimp
 * @author ducbq
 *
 */
@SuppressWarnings("serial")
public class LivestockFeed extends Repository {
	private String code;

	private String name;

	private Unit unit;

	private Category category;

	private String comments;

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

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}