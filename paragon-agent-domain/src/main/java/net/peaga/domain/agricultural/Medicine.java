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
public class Medicine extends Repository {
	private String code;

	private String name;

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

	public Medicine(){
	}

	public Medicine(String code, String name){
		this.code = code;
		this.name = name;
	}
}
