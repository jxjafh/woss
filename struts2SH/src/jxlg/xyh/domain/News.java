package jxlg.xyh.domain;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class News {
	private int NewsID;
	private String Title;
	private String Content;
	private Date Time=new Date();
	private String Author;
	private String NewsImg;
	public News() {
		// TODO Auto-generated constructor stub
	}
	
	public News(int newsID, String title, String content, Date time,
			String author, String newsImg) {
		super();
		NewsID = newsID;
		Title = title;
		Content = content;
		Time = time;
		Author = author;
		NewsImg = newsImg;
	}

	public int getNewsID() {
		return NewsID;
	}
	public void setNewsID(int newsID) {
		NewsID = newsID;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	@Temporal(TemporalType.DATE)
	@Column(updatable = false,nullable=false,length=20)
	public Date getTime() {
		return Time;
	}
	public void setTime(Date time) {
		Time = time;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getNewsImg() {
		return NewsImg;
	}
	public void setNewsImg(String newsImg) {
		NewsImg = newsImg;
	}
	
}