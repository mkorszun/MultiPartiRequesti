package com.property;

import org.apache.http.message.BasicNameValuePair;

public class Property extends BasicNameValuePair {

	private static final long serialVersionUID = -7605280852766646441L;
	
	public Property(String n, Object v){
		super(n, v.toString());
	}
	
	public String getName() {
		return super.getName();
	}
	
	public String getValue() {
		return super.getValue();
	}
}
