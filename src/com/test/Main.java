package com.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.property.FileProperty;
import com.property.Property;
import com.request.MultiPartException;
import com.request.MultiPartRequest;

/**
 * Example
 * 
 * @author mateuszkorszun
 *
 */
public class Main {

	public static void main(String[] args) throws MalformedURLException, MultiPartException{
		
		List<Property> properties = Arrays.asList(new Property[]{
				new Property("P1", new Integer(12)),
				new Property("P2", new String("s"))
		});
		
		List<FileProperty> files = Arrays.asList(new FileProperty[]{
				new FileProperty("test/file1.txt", "application/octet-stream"),
				new FileProperty("test/file2.bin", "application/octet-stream")
		});
		
		MultiPartRequest request = new MultiPartRequest();
		request.request(new URL("http://127.0.0.1:8080/create"), properties, files);
	}
}
