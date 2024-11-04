package application.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.DTO.Board;

/**
 *  데이터 접근 객체
 *  - 게시글 데이터 접근
 */

public class BoardDAO extends JDBConnection{

	/**
	 * 데이터 목록
	 * @return
	 */
	public List<Board> list() {
		// 겍시글 목록을 담을 컬렉션 객체 생성
		List<Board> boardList = new ArrayList<Board>();
		
		// SQL 작성
		String sql = " SELECT * "
					+ " FROM board ";
		
		try {
			
			// 1. SQL 실행 객체 생성 - Statement (stmt)
			stmt = con.createStatement();
			
			// 2. SQL 실행 요청 -> 결과 ResultSet (rs)
			rs = stmt.executeQuery(sql);
			// 3. 조회된 결과를 리스트(boardList)에 추가
			while( rs.next()) {		// next() : 조회 결과의 다음데이터로 이동
				Board board = new Board();
				
				// 결과 데이터 가져오기
				// rs.getXXX("컬럼명")	: 해당 컬럼의 데이터를 반환
				board.setNo( rs.getInt("no"));
				board.setTitle( rs.getString("title"));
				board.setWriter( rs.getString("writer"));
				board.setContent( rs.getString("content"));
				board.setRegDate( rs.getTimestamp("reg_date"));
				board.setUpdDate( rs.getTimestamp("upd_date"));
				board.setView(rs.getInt("View"));
				
				// 게시글 목록 추가
				boardList.add(board);
			}
			
			
		} catch (Exception e) {
			System.out.println("게시글 목록 조회 시, 예외 발생");
			e.printStackTrace();
		}
		
		// 4. 게시글 목록 반환
		
		return boardList;
	}
	
	public List<Board> search(String keyword, String subject) {
		// 겍시글 목록을 담을 컬렉션 객체 생성
		List<Board> boardList = new ArrayList<Board>();
		
		// SQL 작성
		String sql = " SELECT * "
					+ " FROM board "
					+ " where " + subject + " like ?";
		
		try {
			
			// SQL 실행 객체 생성 - PreparedStatement (psmp)
			psmt = con.prepareStatement(sql);
			
			// ? 동적 파라미터 바인딩
			// * psmt.setXXX( 순서번호, 매필할 값)
			psmt.setString(1, "%"+keyword+"%");		// 1번째 ? 파라미터에 매필
			
			// SQL 실행 요청
			rs = psmt.executeQuery();
			// 3. 조회된 결과를 리스트(boardList)에 추가
			while( rs.next()) {		// next() : 조회 결과의 다음데이터로 이동
				Board board = new Board();
				
				// 결과 데이터 가져오기
				// rs.getXXX("컬럼명")	: 해당 컬럼의 데이터를 반환
				board.setNo( rs.getInt("no"));
				board.setTitle( rs.getString("title"));
				board.setWriter( rs.getString("writer"));
				board.setContent( rs.getString("content"));
				board.setRegDate( rs.getTimestamp("reg_date"));
				board.setUpdDate( rs.getTimestamp("upd_date"));
				board.setView(rs.getInt("View"));

				
				// 검색 목록 추가
				boardList.add(board);
			}
			
			
		} catch (Exception e) {
			System.out.println("게시글 검색 시, 예외 발생");
			e.printStackTrace();
		}
		
		// 검색 목록 반환
		
		return boardList;
	}

	/**
	 * 데이터 조회
	 * @param no
	 * @return
	 */
	public Board select(int no) {
		// 게시글 정보 객체 생성
		Board board = new Board();
		
		// SQL 작성
		String sql = " SELECT *"
					+" FROM board "
					+ " WHERE no = ?";
		
		// 데이터 조회 : SQL 실행 객체 생성 -> SQL 실행 요청 -> 조회 결과 -> 반환
		
		try {
			
			// SQL 실행 객체 생성 - PreparedStatement (psmp)
			psmt = con.prepareStatement(sql);
			
			// ? 동적 파라미터 바인딩
			// * psmt.setXXX( 순서번호, 매필할 값)
			psmt.setInt(1, no);		// 1번째 ? 파라미터에 매필
			
			// SQL 실행 요청
			rs = psmt.executeQuery();
			
			// 조회 겨로가 1건 가져오기
			if( rs.next()) {
				board.setNo( rs.getInt("no"));
				board.setTitle( rs.getString("title"));
				board.setWriter( rs.getString("writer"));
				board.setContent( rs.getString("content"));
				board.setRegDate( rs.getTimestamp( "reg_date"));
				board.setUpdDate( rs.getTimestamp("upd_date"));
				board.setView( rs.getInt("view"));
			}
			
			
		} catch (SQLException e) {
			System.out.println("게시글 조회 시, 예외 발생");
			e.printStackTrace();
		}
		return board;
	}

	public int insert(Board board) {
		
		int result = 0;
		
		String sql = " INSERT INTO board (title, writer, content) "
					+" VALUES( ?, ?, ? ) ";
		
		try {
			psmt = con.prepareStatement(sql);			// 쿼리 실행 객체 생성
			psmt.setString( 1, board.getTitle());		// 1번 ? 에 title(제목) 매핑
			psmt.setString( 2, board.getWriter());		// 2번 ? 에 writer(작성자) 매핑
			psmt.setString( 3, board.getContent());		// 3번 ? 에 content(내용) 매필
			result = psmt.executeUpdate();				//	SQL 실행 요청
			// * executeUpdate()
			// SQL (INSERT, UPDATE, DELETE) 실행 시 적용된 데이터 개수를 int 타입으로 받아온다.
			// ex) 게시글 1개 적용 성공 시, result 1
			//					실패 시, result : 0
		} catch (SQLException e) {
			System.err.println("게시글 등록 시, 예외 발생");
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int plusView(int no) {
		int result = 0;
		String sql = "UPDATE board SET view = view + 1 WHERE no = ?";

		
		try {
			psmt = con.prepareStatement(sql);			// 쿼리 실행 객체 생성
			psmt.setInt(1,	no);
			result = psmt.executeUpdate();				//	SQL 실행 요청
			// * executeUpdate()
			// SQL (INSERT, UPDATE, DELETE) 실행 시 적용된 데이터 개수를 int 타입으로 받아온다.
			// ex) 게시글 1개 적용 성공 시, result 1
			//					실패 시, result : 0
		} catch (SQLException e) {
			System.err.println("조회수 증가시, 예외 발생");
			//e.printStackTrace();
		}
		
		return result;
		
	}
	public int update(Board board) {
		int result = 0;
		
		String sql = " UPDATE board "
				+ "SET title = ?"
				+ ",writer = ?"
				+ ",content = ?"
				+ ",upd_date = now()"
				+ "WHERE no = ?";
		
		try {
			psmt = con.prepareStatement(sql);			// 쿼리 실행 객체 생성
			psmt.setString( 1, board.getTitle());		// 1번 ? 에 title(제목) 매핑
			psmt.setString( 2, board.getWriter());		// 2번 ? 에 writer(작성자) 매핑
			psmt.setString( 3, board.getContent());		// 3번 ? 에 content(내용) 매필
			psmt.setInt( 4, board.getNo());		// 3번 ? 에 content(내용) 매필
			result = psmt.executeUpdate();				//	SQL 실행 요청
			// * executeUpdate()
			// SQL (INSERT, UPDATE, DELETE) 실행 시 적용된 데이터 개수를 int 타입으로 받아온다.
			// ex) 게시글 1개 적용 성공 시, result 1
			//					실패 시, result : 0
		} catch (SQLException e) {
			System.err.println("게시글 수정 시, 예외 발생");
			e.printStackTrace();
		}
		
		return result;
	}

	public int delete(int no) {
		int result = 0;
		
		String sql = " DELETE FROM board"
				+ " WHERE no = ?";
		
		try {
			psmt = con.prepareStatement(sql);			// 쿼리 실행 객체 생성
			psmt.setInt(1,	no);
			result = psmt.executeUpdate();				//	SQL 실행 요청
			// * executeUpdate()
			// SQL (INSERT, UPDATE, DELETE) 실행 시 적용된 데이터 개수를 int 타입으로 받아온다.
			// ex) 게시글 1개 적용 성공 시, result 1
			//					실패 시, result : 0
		} catch (SQLException e) {
			System.err.println("게시글 삭제 시, 예외 발생");
			e.printStackTrace();
		}
		
		return result;
	}

}