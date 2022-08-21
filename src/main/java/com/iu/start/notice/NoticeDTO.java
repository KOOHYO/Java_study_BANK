package com.iu.start.notice;

import java.sql.Date;

public class NoticeDTO {

	private Long noticeNum;
	private String noticeTitle;
	private String noticeContents;
	private String noticeWriter;
	private Date noticeRedate;
	private Long noticeHit;
	
	public Long getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeNum(Long noticeNum) {
		this.noticeNum = noticeNum;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContents() {
		return noticeContents;
	}
	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}
	public String getNoticeWriter() {
		return noticeWriter;
	}
	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}
	public Date getNoticeRedate() {
		return noticeRedate;
	}
	public void setNoticeRedate(Date noticeRedate) {
		this.noticeRedate = noticeRedate;
	}
	public Long getNoticeHit() {
		return noticeHit;
	}
	public void setNoticeHit(Long noticeHit) {
		this.noticeHit = noticeHit;
	}
	
}
