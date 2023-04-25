package com.nrt.consultancy.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrt.consultancy.entities.Person;
import com.nrt.consultancy.entities.SMS;
import com.nrt.consultancy.repository.PersonRepository;
import com.nrt.consultancy.services.SMSService;
import java.io.UnsupportedEncodingException;

import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

@Service
public class SMSServiceImpl implements SMSService {
	 @Autowired
	    private PersonRepository personRepository;

	    private String constructUrl(String apiKey, String sendId, String msg, String language, String route, String phone) throws UnsupportedEncodingException {
	        StringBuilder sb = new StringBuilder();
	        sb.append("https://www.fast2sms.com/dev/bulkV2");
	        sb.append("?authorization=").append(apiKey);
	        sb.append("&sender_id=").append(sendId);
	        sb.append("&message=").append(URLEncoder.encode(msg, "UTF-8"));
	        sb.append("&language=").append(language);
	        sb.append("&route=").append(route);
	        sb.append("&numbers=").append(phone);
	        return sb.toString();
	    }

	    @Override
	    public void sendSMS(String phone, String msg, long id) {
	        try {
	            String apiKey = "Jm1Dpk5vjoeSVX8WY6zLQBn0MG9wUTZIatK7s4OlgyRrC3uEHcowQI29OaELn6zY75giPvj0bWV1ZFJr";
	            String sendId = "FASTSM";
	            String language = "english";
	            String route = "v3";

	            String url = constructUrl(apiKey, sendId, msg, language, route, phone);
	            URL urlObject = new URL(url);

	            	HttpsURLConnection con = (HttpsURLConnection) urlObject.openConnection();
	                con.setRequestMethod("GET");
	                con.setRequestProperty("User-Agent", "Mozilla/5.0");
	                con.setRequestProperty("cache-control", "no-cache");

	                int code = con.getResponseCode();
	                System.out.println("Response code : "+code);
	                

	                SMS sms = new SMS();
	                sms.setMessage(msg);
	                sms.setSentDate(new Date());
	                Person person = personRepository.findById(id).get();
	                sms.setPerson(person);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	        
	    }
}
