/**
 * 
 */
package net.peaga.domain.agricultural;

import net.peaga.domain.base.Repository;
import net.peaga.domain.enums.CategoryType;

/**
 * @author ducbq
 *
 */
@SuppressWarnings("serial")
public class Category extends Repository {
	private String objectType = CategoryType.UNKNOWN.getObjectType();

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category(){
	}

	public Category(String objectType, String name){
		this.objectType = objectType;
		this.name = name;
	}
}
