/**
 * 
 */
package net.brilliant.framework.model;

/**
 * @author bqduc
 *
 */
public enum SequenceType {
	DASHBOARD("DSB"),
	DASHLET("DSL"),

	CLIENT_USER_ACCOUNT("CUA"),
	ENTERPRISE("ENT"),

	CATALOGUE("CTL"),
	CATALOGUE_SUBTYPE("CST"),
	
	TICKET("TCK"),
	INCIDENT("INC"),
	CHANGE_REQUEST("CRQ"),
	PROBLEM("PRB"),

	JOB("JOB"),

	BUSINESS_DIVISION("DIV"),
	BUSINESS_UNIT("BU")

	;

	private String type;

	public String getType() {
		return type;
	}

	private SequenceType(String type) {
		this.type = type;
	}
}
