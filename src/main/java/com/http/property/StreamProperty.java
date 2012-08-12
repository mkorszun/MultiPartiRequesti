package main.java.com.http.property;

import java.io.InputStream;

import org.apache.http.entity.mime.content.InputStreamBody;

/**
 * Stream property
 * 
 * @author mateuszkorszun
 *
 */
public class StreamProperty extends InputStreamBody {

	/**
	 * Constructor
	 * 
	 * @param in - input stream
	 * @param contentType
	 * @param filename
	 */
	public StreamProperty(InputStream in, String contentType, String filename) {
		super(in, contentType, filename);
	}

}
