package com.response;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;

/**
 * Encapsulates http response code and message
 * 
 * @author mateuszkorszun
 *
 */
public class Response {

	private int statusCode;
	private String message;
	
	public Response(int statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}
	
	public Response(HttpResponse response) throws IOException {
		
		InputStream is = null;
		
		try{
			
			this.statusCode = response.getStatusLine().getStatusCode();
			int length = (int)response.getEntity().getContentLength();
			
			byte[] msg = new byte[length];
			is = response.getEntity().getContent();
			is.read(msg);
			
			this.message = new String(msg);
		}finally{
			if(is != null){
				is.close();
			}
		}
	}
	
	public String getMessage() {
		return message;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(statusCode).append(":").append(message);
		return builder.toString();
	}
}
