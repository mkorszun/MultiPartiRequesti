package main.java.com.http.test;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import main.java.com.http.property.FileProperty;
import main.java.com.http.property.Property;
import main.java.com.http.request.MultiPartRequest;
import main.java.com.http.request.Request;
import main.java.com.http.request.RequestException;
import main.java.com.http.response.Response;


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
		System.out.println("Res0: "+res0.getMessage());
		
		URL url1 = new URL("http://127.0.0.1:8080/create_save");
		MultiPartRequest request1 = new MultiPartRequest();
		Response res1 = request1.request(url1, properties, files);
		System.out.println("Res1: "+res1.getMessage());
		
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
		System.out.println("Res2: "+res2);
		
		List<Property> properties2 = Arrays.asList(new Property[]{
				new Property("user_id", "user7"),
				new Property("password", "pass7"),
				new Property("id", res1.getMessage()),
		});
		
		URL url3 = new URL("http://127.0.0.1:8080/read_by_id");
		Request request3 = new Request();
		Response res3 = request3.request(url3, properties2);
		System.out.println("Res3: "+res3.getMessage());
		
		URL url4 = new URL("http://127.0.0.1:8080/delete_by_id");
		Request request4 = new Request();
		Response res4 = request4.request(url4, properties2);
		System.out.println("Res4: "+res4.getMessage());
		
		List<Property> properties3 = Arrays.asList(new Property[]{
				new Property("user_id", "user8"),
				new Property("password", "pass8")
		});
		
		URL url5 = new URL("http://127.0.0.1:8080/register_player");
		Request request5 = new Request();
		Response res5 = request5.request(url5, properties3);
		System.out.println("Res5: "+res5.getMessage());
		
		List<Property> properties4 = Arrays.asList(new Property[]{
				new Property("user_id", "user8"),
				new Property("password", "pass8")
		});
		
		URL url6 = new URL("http://127.0.0.1:8080/delete_player");
		Request request6 = new Request();
		Response res6 = request6.request(url6, properties4);
		System.out.println("Res6: "+res6.getMessage());
		
//		Res0: Save not found
//		Res1: 3606cca1eb318ff462ff8711b6ed76ac
//		Res2: 200:application/json:[{"_id":"3606cca1eb318ff462ff8711b6ed76ac","_rev":"1-39f7dabdd466cc87db8a9ec0c985b68a","type":"save","name":"Save11","game":"SC8","user_id":"user7","_attachments":{"file1.txt":{"content_type":"application/octet-stream","digest":"md5-RH242U6wX5RHptdTFYXWXw==","length":26,"content":"dsfsd ds fs dfsd ds fds ds"},"file2.bin":{"content_type":"application/octet-stream","digest":"md5-fcQS9k/pwhqFP0x1fR4yJw==","length":117,"content":"004504395043950349205934059042359043905043d034d5035m04m5d340d5m04359,m0439dm0349d,m0349d5m0349d0m34025dm340md340md034"}}}]
//		Res3: [{"_id":"3606cca1eb318ff462ff8711b6ed76ac","_rev":"1-39f7dabdd466cc87db8a9ec0c985b68a","type":"save","name":"Save11","game":"SC8","user_id":"user7","_attachments":{"file1.txt":{"content_type":"application/octet-stream","digest":"md5-RH242U6wX5RHptdTFYXWXw==","length":26},"file2.bin":{"content_type":"application/octet-stream","digest":"md5-fcQS9k/pwhqFP0x1fR4yJw==","length":117}}}]
//		Res4: ok
//		Res5: ok
//		Res6: ok
	}
}