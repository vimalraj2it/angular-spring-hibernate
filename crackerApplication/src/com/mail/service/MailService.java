package com.mail.service;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.mail.connect.ApacheHttpClientPost;
import com.mail.pojo.Headers;
import com.mail.pojo.Message;
import com.mail.pojo.Send;
import com.mail.pojo.To;




// TODO: Auto-generated Javadoc
/**
 * The Class MailService.
 */
public class MailService extends Constant {
	
	

	

	/**
	 * Sent mail.
	 *
	 * @param email the email
	 * @param name the name
	 * @return the string
	 */
	public String sentMail(String email,String name){
		
		try {
			
			 Send send = new Send();
			 send.setAsync(false);
			 send.setKey(MANDRILL_KEY);
			 Message msg = new Message();
			 msg.setHtml(html_content);
			 msg.setText(msg_content);
			 msg.setSubject(SUBJECT);
			 msg.setFromEmail(fromEmail);
			 msg.setFromName(fromName);
			 ArrayList<To> toList = new ArrayList<To>();
			 To to1 = new To();
			 to1.setEmail(email);
			 to1.setName(name);
			 to1.setType(to);
			 
			 
			 toList.add(to1);
			 
			 To to2 = new To();
			 to2.setEmail(fromEmail);
			 to2.setName(fromName);
			 to2.setType(cc);
			 
			 
			 toList.add(to2);
			 msg.setTo(toList);
			 Headers headers = new Headers();
			 headers.setReplyTo(fromEmail);
			 msg.setHeaders(headers);
			 
			 send.setMessage(msg);
			String response =  ApacheHttpClientPost.postCall(url, new Gson().toJson(send));
			
			if(response.contains(sent))
				return sent;
			else
				return error;
				 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
