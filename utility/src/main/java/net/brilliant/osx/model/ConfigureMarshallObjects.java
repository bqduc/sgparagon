/**
 * 
 */
package net.brilliant.osx.model;

/**
 * @author ducbq
 *
 */
public enum ConfigureMarshallObjects {
	CONTACTS ("contacts", ""), 
	ITEMS("items", ""),
	LOCALIZED_ITEMS("localizedItems", ""),
	LANGUAGES("languages", ""),
	INVENTORY_ITEMS("inventory-items", "load-inventory-items"),
	MEASURE_UNITS("Measure Units", "load-measure-units"),
	BUSINESS_UNITS("Business Units", "load-business-units"),

	;
	private String object;
	private String configName;

	public String getName() {
		return object;
	}

	private ConfigureMarshallObjects(String object, String configName) {
		this.object = object;
		this.configName = configName;
	}

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}
}
