package main.java.com.http.property;

import java.io.File;

import org.apache.http.entity.mime.content.FileBody;

/**
 * File property
 * 
 * @author mateuszkorszun
 *
 */
public class FileProperty extends FileBody {
	
	/**
	 * Constructor
	 * 
	 * @param path to file
	 * @param contentType
	 */
	public FileProperty(String path, String contentType) {
		super(new File(path), contentType);
	}
	
}
