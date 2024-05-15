package boardServer.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import boardServer.user.model.UserResponseDto;

import javax.servlet.http.HttpServletRequest;

import util.DBManager;

public class BoardDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static BoardDao instance = new BoardDao();
	
	public static BoardDao getInstance() {
		return instance;
	}
	
	public BoardResponseDto findAndUpdateBoardByTitleAndBoardId(String title, String content, String id, String preTitle, String preBoardId) {
		BoardResponseDto board = null;
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "UPDATE board set board_content=?, board_title=? WHERE board_title=? AND board_Id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.setString(2, title);
			pstmt.setString(3, preTitle);
			pstmt.setString(4, preBoardId);
			
			pstmt.execute();
			
			board = findBoadByTitleAndContentAndBoardId(title, content, id);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return board;
	}
	
	public BoardResponseDto findBoadByTitleAndContentAndBoardId(String title, String content, String id) {
		BoardResponseDto board = null;
		
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT board_title, board_content, board_id, notice_check FROM board WHERE board_title=? AND board_content=? AND board_Id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String boardTitle = rs.getString(1);
				String boardContent = rs.getString(2);
				String boardId = rs.getString(3);
				
				System.out.println("BoardDao");
				System.out.println(boardTitle);
				System.out.println(boardContent);
				System.out.println(boardId);
				
				board = new BoardResponseDto(boardTitle, boardContent, boardId);
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
			String sql = "INSERT INTO board(board_title, board_content, board_id, notice_check)" + 
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
	
	public ArrayList<Board> getList() {
		ArrayList<Board> list = new ArrayList<Board>();
		
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT board_title, board_content, board_id, board_time FROM board ORDER BY board_time DESC LIMIT 10";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Board board = new Board();
				board.setTitle(rs.getString(1));
				board.setContent(rs.getString(2));
				board.setBoardId(rs.getString(3));
				board.setRegDate(rs.getString(4));
				list.add(board);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Board getContent(String title, String boardId) {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM board WHERE board_title=? AND board_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, boardId);
			System.out.println(pstmt);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("aaa");
				Board board = new Board();
				board.setTitle(rs.getString(1));
				board.setContent(rs.getString(2));
				board.setBoardId(rs.getString(3));
				board.setRegDate(rs.getString(4));
				System.out.println(board.getTitle());
				System.out.println(board.getContent());
				System.out.println(board.getBoardId());
				System.out.println(board.getRegDate());
				return board;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("bbbbb");
		return null;
	}
	
	public void deleteBoard(String title, String boardId) {
		try {
			conn = DBManager.getConnection();
			String sql = "DELETE FROM board WHERE board_title=? AND board_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, boardId);
			pstmt.execute();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
