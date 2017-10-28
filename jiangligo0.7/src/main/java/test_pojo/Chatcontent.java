package test_pojo;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

public class Chatcontent {
	private int id;

	private Timestamp time;
	private String sender;
	private String receiver;
	private String content;
	public Chatcontent(){}
	public Chatcontent(String receiver2, String sender2, String content2) {
		// TODO Auto-generated constructor stub
		this.receiver=receiver2;
		this.sender=sender2;
		this.content=content2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
public Timestamp getTime() {
	return time;
}
public void setTime(Timestamp time) {
	this.time = time;
}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
