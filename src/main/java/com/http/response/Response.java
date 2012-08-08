package main.java.com.http.response;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

/**
 * Encapsulates http response code, content type and message
 * 
 * @author mateuszkorszun
 *
 */
public class Response {

	private int statusCode;
	private String message;
	private String contentType;
	
	public Response(int statusCode, String message, String contentType) {
		this.statusCode = statusCode;
		this.message = message;
		this.contentType = contentType;
	}
	
	public Response(HttpResponse response) throws IOException {
		
		InputStream is = null;
		
		try{
			
			this.statusCode = response.getStatusLine().getStatusCode();
			HttpEntity entity = response.getEntity();
			int length = (int)entity.getContentLength();
			this.contentType = entity.getContentType().getValue();
			
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
	
	public String getContentType() {
		return contentType;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(statusCode).append(":");
		builder.append(contentType).append(":");
		builder.append(message);
		return builder.toString();
	}
}
