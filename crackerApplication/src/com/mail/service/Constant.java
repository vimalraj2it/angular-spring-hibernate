package com.mail.service;

public class Constant {

	protected static final String MANDRILL_KEY = "pBqEqbU5BNwLw6Euedbmeg";
	protected static final String SUBJECT = "Order Notification";
	protected static final String fromEmail = "vimalraj2it@gmail.com";
	protected static final String fromName = "vimal";
	protected static final String url ="/messages/send.json";
	protected static final String cc ="cc";
	protected static final String to ="to";
	
	protected static final String msg_content ="Please Collect Your Order..";
	protected static final String html_content ="<p>"+msg_content+"</p>";
	
	public static final String sent = "sent";
	public static final String error = "error";

}
