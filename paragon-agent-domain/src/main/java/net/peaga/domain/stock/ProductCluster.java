package net.peaga.domain.stock;

import net.peaga.domain.base.Repository;

/**
 * Product / service group for our class stock holding information. 
 * 
 * @author DucBQ
 */
@SuppressWarnings("serial")
public class ProductCluster extends Repository{
	private String code;

	private String name;

	private String info;

	public ProductCluster(){
	}

	public ProductCluster(String code, String name, String info){
		this.code = code;
		this.name = name;
		this.info = info;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
