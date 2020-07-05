package net.peaga.domain.stock;

import net.peaga.domain.base.Repository;

/**
 * Product / service brand for our class stock holding information. (Optical Science will be holding its brand information.)
 * 
 * @author DucBQ
 */
public class ProductBrand extends Repository {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3330598926717574191L;
	private String code;
	private String name;
	private String info;

	public ProductBrand(){
	}

	public ProductBrand(String code, String name){
		this.code = code;
		this.name = name;
	}

	public ProductBrand(String code, String name, String info){
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
