package boardServer.board.model;

import java.sql.Timestamp;

public class BoardResponseDto {
	private String title;
	private String content;
	private String boardId;
	private String noticeCheck;
	
	public BoardResponseDto(String title, String content, String boardId, String noticeCheck) {
		super();
		this.title = title;
		this.content = content;
		this.boardId = boardId;
		this.noticeCheck = noticeCheck;
	}
}
