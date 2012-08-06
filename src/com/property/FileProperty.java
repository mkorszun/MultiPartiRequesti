package com.property;

import java.io.File;

import org.apache.http.entity.mime.content.FileBody;

public class FileProperty extends FileBody {
	
	public FileProperty(String path, String contentType) {
		super(new File(path), contentType);
	}
	
}
