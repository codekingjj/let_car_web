package boardServer.board.model;

import java.sql.Timestamp;

public class Board {
	private String title;
	private String content;
	private String boardId;
	private Timestamp regDate;
	private String noticeCheck;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public String getNoticeCheck() {
		return noticeCheck;
	}
	public void setNoticeCheck(String noticeCheck) {
		this.noticeCheck = noticeCheck;
	}
	
	
}
