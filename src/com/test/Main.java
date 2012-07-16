package com.test;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.property.FileProperty;
import com.property.Property;
import com.request.MultiPartRequest;
import com.request.RequestException;
import com.request.Request;
import com.response.Response;

/**
 * Example
 * 
 * @author mateuszkorszun
 *
 */
public class Main {

	public static void main(String[] args) throws RequestException, IllegalStateException, IOException{
		
		List<Property> properties = Arrays.asList(new Property[]{
				new Property("user_id", "user3"),
				new Property("password", "pass3")
		});
		
		List<FileProperty> files = Arrays.asList(new FileProperty[]{
				new FileProperty("test/file1.txt", "application/octet-stream"),
				new FileProperty("test/file2.bin", "application/octet-stream")
		});
		
		URL url1 = new URL("http://127.0.0.1:8080/create");
		MultiPartRequest request1 = new MultiPartRequest();
		Response res1 = request1.request(url1, properties, files);
		System.out.println(res1);
		
		URL url2 = new URL("http://127.0.0.1:8080/register");
		Request request2 = new Request();
		Response res2 = request2.request(url2, properties);
		System.out.println(res2);
	}
}