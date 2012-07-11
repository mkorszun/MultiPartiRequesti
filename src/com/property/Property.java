package com.property;

public class Property {

	private String name;
	private Object value;
	
	public Property(String n, Object v){
		this.name = n;
		this.value = v;
	}
	
	public String getName() {
		return name;
	}
	
	public Object getValue() {
		return value;
	}
}
