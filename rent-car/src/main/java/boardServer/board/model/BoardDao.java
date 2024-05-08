package boardServer.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import util.DBManager;

public class BoardDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static BoardDao instance = new BoardDao();
	
	public static BoardDao getInstance() {
		return instance;
	}
	
	public BoardResponseDto findBoadByTitleAndContentAndBoardId(String title, String content, String id) {
		BoardResponseDto board = null;
		
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT board_title, board_content, board_id, notice_check FROM board WHRER board_title=? AND board_content=? AND board_Id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String boardTitle = rs.getString(1);
				String boardContent = rs.getString(2);
				String boardId = rs.getString(3);
				String noticeCheck = rs.getString(4);
				
				board = new BoardResponseDto(boardTitle, boardContent, boardId, noticeCheck);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return board;
	}
	
	public BoardResponseDto createBoard(BoardRequestDto boardDto) {
		System.out.println(boardDto.getTitle());
		System.out.println(boardDto.getContent());
		System.out.println(boardDto.getBoardId());
		System.out.println(boardDto.getNoticeCheck());
		
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO board(board_title. board_content, board_id, notice_check)" + 
					"VALUES(?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boardDto.getTitle());
			pstmt.setString(2, boardDto.getContent());
			pstmt.setString(3, boardDto.getBoardId());
			pstmt.setString(4, boardDto.getNoticeCheck());
			
			pstmt.execute();
			
			return findBoadByTitleAndContentAndBoardId(boardDto.getTitle(), boardDto.getContent(), boardDto.getBoardId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
}
