/**
 * 
 */
package net.peaga.domain.agricultural;

import net.peaga.domain.base.Repository;

/**
 * Prawn seed (category)
 * @author ducbq
 *
 */
@SuppressWarnings("serial")
public class Seed extends Repository {
	private String code;

	private String name;

	private String comments;

	/**The source provider*/
	private String hatchery;

	public String getHatchery() {
		return hatchery;
	}

	public void setHatchery(String hatchery) {
		this.hatchery = hatchery;
	}

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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
