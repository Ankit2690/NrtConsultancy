package com.nrt.consultancy.services;


public interface EmailService {

	void sendEmail(String to, String sub, String msg,long id);
	
}
