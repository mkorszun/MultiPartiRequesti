package main.java.com.http.property;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.entity.mime.content.ByteArrayBody;

/**
 * Byte array property
 * 
 * @author mateuszkorszun
 *
 */
public class ByteArrayProperty extends ByteArrayBody {

	/**
	 * Constructor
	 * 
	 * @param in - input stream
	 * @param contentType
	 * @param filename
	 * @throws IOException
	 */
	public ByteArrayProperty(InputStream in, String contentType, String filename) throws IOException{
		this(IOUtils.toByteArray(in), contentType, filename);
	}
	
	/**
	 * Constructor
	 * 
	 * @param in - byte array
	 * @param contentType
	 * @param filename
	 */
	public ByteArrayProperty(byte[] in, String contentType, String filename) {
		super(in, contentType, filename);
	}

}
