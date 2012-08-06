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
				new Property("user_id", "user7"),
				new Property("password", "pass7"),
				new Property("game", "SC8"),
				new Property("name", "Save11"),
				new Property("type", "save")
		});
		
		List<FileProperty> files = Arrays.asList(new FileProperty[]{
				new FileProperty("test/file1.txt", "application/octet-stream"),
				new FileProperty("test/file2.bin", "application/octet-stream")
		});
		
		URL url0 = new URL("http://127.0.0.1:8080/delete_by_name");
		Request request0 = new Request();
		Response res0 = request0.request(url0, properties);
		System.out.println(res0);
		
		URL url1 = new URL("http://127.0.0.1:8080/create_save");
		MultiPartRequest request1 = new MultiPartRequest();
		Response res1 = request1.request(url1, properties, files);
		System.out.println(res1);
		
		List<Property> properties1 = Arrays.asList(new Property[]{
				new Property("user_id", "user7"),
				new Property("password", "pass7"),
				new Property("game", "SC8"),
				new Property("name", "Save11"),
				new Property("attach", true)
		});
		
		URL url2 = new URL("http://127.0.0.1:8080/read_by_name");
		Request request2 = new Request();
		Response res2 = request2.request(url2, properties1);
		System.out.println(res2);
		
		List<Property> properties2 = Arrays.asList(new Property[]{
				new Property("user_id", "user7"),
				new Property("password", "pass7"),
				new Property("id", res1.getMessage()),
		});
		
		URL url3 = new URL("http://127.0.0.1:8080/read_by_id");
		Request request3 = new Request();
		Response res3 = request3.request(url3, properties2);
		System.out.println(res3);
		
		URL url4 = new URL("http://127.0.0.1:8080/delete_by_id");
		Request request4 = new Request();
		Response res4 = request4.request(url4, properties2);
		System.out.println(res4);
		
		List<Property> properties3 = Arrays.asList(new Property[]{
				new Property("user_id", "user8"),
				new Property("password", "pass8")
		});
		
		URL url5 = new URL("http://127.0.0.1:8080/register_player");
		Request request5 = new Request();
		Response res5 = request5.request(url5, properties3);
		System.out.println(res5);
		
		List<Property> properties4 = Arrays.asList(new Property[]{
				new Property("user_id", "user8"),
				new Property("password", "pass8")
		});
		
		URL url6 = new URL("http://127.0.0.1:8080/delete_player");
		Request request6 = new Request();
		Response res6 = request6.request(url6, properties4);
		System.out.println(res6);
	}
}