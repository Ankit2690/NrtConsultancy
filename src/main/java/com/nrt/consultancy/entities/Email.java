package com.nrt.consultancy.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Email {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String subject;
private String body;
private Date sentDate;
@ManyToOne
@JoinColumn(name = "person_id", referencedColumnName = "id")
private Person person;

public Person getPerson() {
	return person;
}
public void setPerson(Person person) {
	this.person = person;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getBody() {
	return body;
}
public void setBody(String body) {
	this.body = body;
}
public Date getSentDate() {
	return sentDate;
}
public void setSentDate(Date sentDate) {
	this.sentDate = sentDate;
}

}
