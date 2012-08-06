package com.property;

import java.io.InputStream;

import org.apache.http.entity.mime.content.InputStreamBody;

public class StreamProperty extends InputStreamBody {

	public StreamProperty(InputStream in, String filename) {
		super(in, filename);
	}

}
