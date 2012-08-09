package main.java.com.http.property;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.entity.mime.content.ByteArrayBody;

public class ByteArrayProperty extends ByteArrayBody {

	public ByteArrayProperty(InputStream in, String contentType, String filename) throws IOException{
		this(IOUtils.toByteArray(in), contentType, filename);
	}
	
	public ByteArrayProperty(byte[] in, String contentType, String filename) {
		super(in, contentType, filename);
	}

}
