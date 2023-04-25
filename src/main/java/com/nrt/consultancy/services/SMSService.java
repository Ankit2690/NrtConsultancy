package com.nrt.consultancy.services;


public interface SMSService {

	void sendSMS(String phone, String msg, long id);

}
