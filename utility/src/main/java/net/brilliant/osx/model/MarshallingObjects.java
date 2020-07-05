/**
 * 
 */
package net.brilliant.osx.model;

/**
 * @author ducbq
 *
 */
public enum MarshallingObjects {
	CONTACTS ("contacts"), 
	ITEMS("items"),
	LOCALIZED_ITEMS("localizedItems"),
	LANGUAGES("languages"),
	INVENTORY_ITEMS("inventory-items"),
	MEASURE_UNITS("Measure Units"),

	;
	private String object;

	public String getName() {
		return object;
	}

	private MarshallingObjects(String object) {
		this.object = object;
	}
}
