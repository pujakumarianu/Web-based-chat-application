package com.chatapplication.controller;

import java.io.*;
public class Message implements Serializable{

	private String message;
	private String firstname;
	private int user_id;
	private int message_id;
	private String date;
	private String lastname;
	private String fromMessage;
	
	public Message() {
		
		
	}
	
	public void setfromMessage(String fromMessage) {
		this.fromMessage=fromMessage;
	}
	
	public String getfromMessage() {
		return fromMessage;
	}
	
	public void setLastname(String lastname) {
		this.lastname=lastname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setDate(String date) {
		this.date=date;
	}
	public String getDate() {
		return  date;
	}
	
	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}

	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setMessage_firstname(String firstname) {
		this.firstname = firstname;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
}
