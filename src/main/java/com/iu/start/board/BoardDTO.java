package com.iu.start.board;

import java.sql.Date;

public class BoardDTO {

	private Long boardNum;
	private String boardTitle;
	private String boardDetail;
	private String boardUserName;
	private Date boardDate;
	private Integer boardHits;
	
	public Long getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Long boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardDetail() {
		return boardDetail;
	}
	public void setBoardDetail(String boardDetail) {
		this.boardDetail = boardDetail;
	}
	public String getBoardUserName() {
		return boardUserName;
	}
	public void setBoardUserName(String boardUserName) {
		this.boardUserName = boardUserName;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public Integer getBoardHits() {
		return boardHits;
	}
	public void setBoardHits(Integer boardHits) {
		this.boardHits = boardHits;
	}
	
}
