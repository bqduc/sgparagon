/**
 * 
 */
package net.peaga.domain.agricultural;

import net.peaga.domain.base.Repository;

/**
 * @author ducbq
 *
 */
@SuppressWarnings("serial")
public class Unit extends Repository {
	private String code;

	private String name;

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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
}
