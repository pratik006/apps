package com.prapps.yavni.dto;

public enum BloodTypes {

	RBC("RBC"),
	WBC("WBC"),
	PLASMA("PLASMA"),
	PLATELETS("PLATELETS");
	
	private final String value;
	
	BloodTypes(String type) {
		value = type;
	}
	
	public String toString() {
        return value;
    }
}
