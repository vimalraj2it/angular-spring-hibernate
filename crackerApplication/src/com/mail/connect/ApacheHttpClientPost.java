package com.mail.connect;

/**
 * Hello world!
 *
 */
import java.io.BufferedReader;

import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
 
public class ApacheHttpClientPost{
 
	private final static String BASE_URL = "https://mandrillapp.com/api/1.0/" ;
	
	public static  String postCall(String url,String data ) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		StringBuffer responseText = new StringBuffer();
		String output = null;
	  try {
 
		
		HttpPost postRequest = new HttpPost(
				BASE_URL+url);
		postRequest.addHeader("accept", "application/json");
		StringEntity input = new StringEntity(data);
		input.setContentType("application/json");
		postRequest.setEntity(input);
 
		HttpResponse response = httpClient.execute(postRequest);
 
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
			   + response.getStatusLine().getStatusCode());
		}
 
		BufferedReader br = new BufferedReader(
                         new InputStreamReader((response.getEntity().getContent())));
 
		
		
		while ( (output = br.readLine()) != null) {
			responseText.append(output);
		}
		
		httpClient.getConnectionManager().shutdown();
 
	  } catch (Exception e) {
 
		e.printStackTrace();
 
	  } finally{
		  httpClient.getConnectionManager().shutdown();
	  }
	  return responseText.toString();
	  
 
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApacheHttpClientPost post = new ApacheHttpClientPost();
		String url ="users/info.json";
		
		//url = "/messages/send.json"
		String data ="{\"key\":\"pBqEqbU5BNwLw6Euedbmeg\"}";
		System.out.println(post.postCall(url, data));
	}
 
}
