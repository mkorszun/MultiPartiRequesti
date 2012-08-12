package main.java.com.http.property;

import org.apache.http.message.BasicNameValuePair;

/**
 * Property
 * 
 * @author mateuszkorszun
 *
 */
public class Property extends BasicNameValuePair {

	private static final long serialVersionUID = -7605280852766646441L;
	
	/**
	 * Constructor
	 * 
	 * @param n - name
	 * @param v - value
	 */
	public Property(String n, Object v){
		super(n, v.toString());
	}
	
}
