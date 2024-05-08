package boardServer.board.model;

public class BoardRequestDto {
	private String title;
	private String content;
	private String boardId;
	private String noticeCheck;
	
	public BoardRequestDto(String title, String content, String boardId, String noticeCheck) {
		super();
		this.title = title;
		this.content = content;
		this.boardId = boardId;
		this.noticeCheck = noticeCheck;
	}
	
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public String getNoticeCheck() {
		return noticeCheck;
	}
	public void setNoticeCheck(String noticeCheck) {
		this.noticeCheck = noticeCheck;
	}
	
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
}
