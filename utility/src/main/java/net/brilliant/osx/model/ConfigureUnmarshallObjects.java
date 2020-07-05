/**
 * 
 */
package net.brilliant.osx.model;

/**
 * @author ducbq
 *
 */
public enum ConfigureUnmarshallObjects {
	CONTACTS ("contacts", ""), 
	ITEMS("items", ""),
	LOCALIZED_ITEMS("localizedItems", ""),
	LANGUAGES("languages", ""),
	INVENTORY_ITEMS("inventory-items", "load-inventory-items"),
	MEASURE_UNITS("Measure Units", "load-measure-units"),
	BUSINESS_UNITS("business-units", "load-business-units"),

	;
	private String dataSheetId;
	private String configuredEntryName;

	private ConfigureUnmarshallObjects(String dataSheetId, String configuredEntryName) {
		this.dataSheetId = dataSheetId;
		this.configuredEntryName = configuredEntryName;
	}

	public String getDataSheetId() {
		return dataSheetId;
	}

	public String getConfiguredEntryName() {
		return configuredEntryName;
	}

}
