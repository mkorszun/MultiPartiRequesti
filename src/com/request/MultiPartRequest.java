package com.request;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;

import com.property.FileProperty;
import com.property.Property;

/**
 * Wraps HTTP POST multipart request
 * 
 * @author mateuszkorszun
 *
 */
public class MultiPartRequest {
	
	/**
	 * Send multipart Post request
	 * 
	 * @param url
	 * @param params
	 * @return {@link HttpEntity}
	 * @throws {@link MultiPartException}
	 */
	public HttpEntity request(URL url, Collection<Property> params) throws MultiPartException{
		return request(new DefaultHttpClient(), url, params, Collections.<FileProperty> emptyList());
	}
	
	/**
	 * Send multipart Post request
	 * 
	 * @param url
	 * @param params
	 * @param files
	 * @return {@link HttpEntity}
	 * @throws {@link MultiPartException}
	 */
	public HttpEntity request(URL url, Collection<Property> params, 
			Collection<FileProperty> files) throws MultiPartException{
		return request(new DefaultHttpClient(), url, params, files);
	}
	
	/**
	 * Send multipart Post request
	 * 
	 * @param client
	 * @param url
	 * @param params
	 * @param files
	 * @return {@link HttpEntity}
	 * @throws {@link MultiPartException}
	 */
	public HttpEntity request(HttpClient client, URL url, Collection<Property> params, 
			Collection<FileProperty> files) throws MultiPartException{
		try{
			MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
			
			for(Property p : params){
				entity.addPart(p.getName(), new StringBody(p.getValue().toString()));
			}
			
			for(FileProperty f : files){
				FileBody fileBody = new FileBody(new File(f.getPath()), f.getContentType());
				entity.addPart(f.name(), fileBody);
			}
			
			HttpPost httpPost = new HttpPost(url.toString());
			httpPost.setEntity(entity);
			
			HttpResponse response = client.execute(httpPost);
			return response.getEntity();	

		}catch(UnsupportedEncodingException e){
			throw new MultiPartException("Failed to decode property: "+e.getMessage());
		} catch (ClientProtocolException e) {
			throw new MultiPartException("Http connection problem: "+e.getMessage());
		} catch (IOException e) {
			throw new MultiPartException("IO failure: "+e.getMessage());
		}
	}
}