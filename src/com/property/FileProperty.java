package com.property;

import org.apache.commons.io.FilenameUtils;

public class FileProperty {

	private String path;
	private String contentType;
	
	public FileProperty(String path, String contentType) {
		this.path = path;
		this.contentType = contentType;
	}
	
	public String getContentType() {
		return contentType;
	}
	
	public String getPath() {
		return path;
	}
	
	public String name(){
		StringBuilder builder = new StringBuilder();
		builder.append("file/");
		builder.append(FilenameUtils.getName(path));
		return builder.toString();
	}
}
