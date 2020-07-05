package net.peaga.domain.enums;

import java.io.Serializable;

public enum CategoryType implements Serializable{
	LIVESTOCK_FEED("POND"),
	POND("POND"),
	MEDICINE("MEDICINE"),
	EQUIPMENT("EQUIPMENT"),
	UNKNOWN("UNKNOWN")
	;
	
	String objectType;

	private CategoryType(String objectType){
		this.objectType = objectType;
	}
	
	public String getObjectType(){
		return objectType;
	}
	
}
