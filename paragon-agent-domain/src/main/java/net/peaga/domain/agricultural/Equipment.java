package net.peaga.domain.agricultural;

import net.peaga.domain.base.Repository;

@SuppressWarnings("serial")
public class Equipment extends Repository{
	private String code;

	private String name;

	private String type; //This value is query from inventory dictionary. It can be a normal equipment, live stock feed, ....

	private Unit unit;

	private Category category;

	private String description;

	public Equipment() {
	}

	public Equipment(String name, String description) {
		this.name = name;
		this.setDescription(description);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Equipment[code=" + code + ", name=" + name + "]";
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
