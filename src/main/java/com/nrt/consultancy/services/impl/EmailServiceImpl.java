package com.nrt.consultancy.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.nrt.consultancy.entities.Email;
import com.nrt.consultancy.entities.Person;
import com.nrt.consultancy.repository.EmailRepository;
import com.nrt.consultancy.repository.PersonRepository;
import com.nrt.consultancy.services.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired 
	private JavaMailSender javaMailSender;
    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private PersonRepository personRepository;
    
    public void sendEmail(String recipientEmail, String subject, String body,long id) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
        
        Email email = new Email();
        email.setSubject(subject);
        email.setBody(body);
        email.setSentDate(new Date());
        Person person = personRepository.findById(id).get();
        email.setPerson(person);
        emailRepository.save(email);
    }
}


