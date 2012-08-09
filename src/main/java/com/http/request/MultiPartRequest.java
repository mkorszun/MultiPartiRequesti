package main.java.com.http.request;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;

import main.java.com.http.property.Property;
import main.java.com.http.response.Response;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;

import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;


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
	 * @return {@link Response} 
	 * @throws {@link IOException}
	 * @throws {@link RequestException}
	 */
	public Response request(URL url, Collection<Property> params) throws RequestException, IOException{
		return request(new DefaultHttpClient(), url, params, Collections.<ContentBody> emptyList());
	}
	
	/**
	 * Send multipart Post request
	 * 
	 * @param url
	 * @param params
	 * @param files
	 * @return {@link Response}
	 * @throws {@link IOException} 
	 * @throws {@link RequestException}
	 */
	public Response request(URL url, Collection<Property> params, 
			Collection<? extends ContentBody> files) throws RequestException, IOException{
		return request(new DefaultHttpClient(), url, params, files);
	}
	
	/**
	 * Send multipart Post request
	 * 
	 * @param client
	 * @param url
	 * @param params
	 * @param files
	 * @return {@link Response}
	 * @throws {@link IOException} 
	 * @throws {@link RequestException}
	 */
	public Response request(HttpClient client, URL url, Collection<Property> params, 
			Collection<? extends ContentBody> files) throws RequestException, IOException{
		try{
			MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
			
			for(Property p : params){
				entity.addPart(p.getName(), new StringBody(p.getValue().toString()));
			}
			
			for(ContentBody f : files){
				entity.addPart(f.getFilename(), f);
			}
			
			HttpPost httpPost = new HttpPost(url.toString());
			httpPost.setEntity(entity);
			
			HttpResponse response = client.execute(httpPost);
			return new Response(response);

		}catch(UnsupportedEncodingException e){
			throw new RequestException("Failed to decode property: "+e.getMessage());
		} catch (ClientProtocolException e) {
			throw new RequestException("Http connection problem: "+e.getMessage());
		}
	}
}