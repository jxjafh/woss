package jxlg.xyh.domain;

import java.sql.Time;

public class Notice {
	private int NoticeID;
	private String Content;
	public Notice()
	{}
	public Notice(int noticeID, String content) {
		super();
		NoticeID = noticeID;
		Content = content;
	}
	public int getNoticeID() {
		return NoticeID;
	}
	public void setNoticeID(int noticeID) {
		NoticeID = noticeID;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}

}
