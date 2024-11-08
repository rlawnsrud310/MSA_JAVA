

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.domain.Board;

/**
 * Servlet implementation class BoardDatailServlet
 */
@WebServlet("/board/*")
public class BoardDatailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDatailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("게시글 등록 요청");
		// 요청, 응답 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// URL 경로에서 번호 추출
		// /HTTP/board/10
		String pathInfo = request.getPathInfo();
		System.out.println("요청 경로" + pathInfo);
		
		// [0]		[1]		[2]
		// [HTTP][board][10]
		String[] path = pathInfo.split("/");
		int no = Integer.parseInt(path[1]);		// String --> int 정수로 변환
		
		// 게시글 조회 요청
		Board board = new Board("조회된 글", "김조은", "내용");
		board.setNo(no);
		
		/*
		 	{ "no" : "10", "title" : "조회된 글", "writer" : "김조은", "content" : "내용" }
		 */
		// Board 객체를 json 으로 변환
		StringBuilder json = new StringBuilder();
		json.append("{");
		json.append("\"no\":\"" + board.getNo() + "\",");
		json.append("\"title\":\"" + board.getTitle() + "\",");
		json.append("\"writer\":\"" + board.getWriter() + "\",");
		json.append("\"content\":\"" + board.getContent() + "\"");
		json.append("}");

		
		// 응답 컨텐츠 타입 : application/json
		response.setContentType("application/json");
		// 데이터 응답
		response.getWriter().write(json.toString());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("게시글 등록 요청");
		// 요청, 응답 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		doGet(request, response);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("게시글 등록 요청");
		// 요청, 응답 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// URL 경로에서 번호 추출
		// /HTTP/board/10
		String pathInfo = request.getPathInfo();
		System.out.println("요청 경로" + pathInfo);
		
		// [0]		[1]		[2]
		// [HTTP][board][10]
		String[] path = pathInfo.split("/");
		int no = Integer.parseInt(path[1]);		// String --> int 정수로 변환
		
		// 게시글 등록 처리 요청
		Board board = new Board("수정된 글", "김조은" , "내용");
		// 게시글 삭제 요청
		board.setNo(no);
		
		System.out.println("수정된 게시글 : " + board);
		Random random = new Random();
		int result = random.nextInt(2);	// 0. 1
		
		
		// 응답 처리
		// FORM 요청
//				
//		// request.getContextPath() : 최사우이 경로 (루트 컨텍스트)
//		if( result > 0)
//			// 게시글 목록으로 이동
//			response.sendRedirect(request.getContextPath() + "/board/list.jsp");
//		else 
//			// 게시글 등록으로 이동(에러메세지 포함)
//			response.sendRedirect(request.getContextPath() + "/board/update.jsp?error=FAIL");		
				
				//비동기 요청 시
				// - 등록성공
				if( result > 0)
					response.getWriter().write("SUCCESS");
				// - 등록 실패
				else
					response.getWriter().write("FATL");
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("게시글 등록 요청");
		// 요청, 응답 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// URL 경로에서 번호 추출
		// /HTTP/board/10
		String pathInfo = request.getPathInfo();
		System.out.println("요청 경로" + pathInfo);
		
		// [0]		[1]		[2]
		// [HTTP][board][10]
		String[] path = pathInfo.split("/");
		int no = Integer.parseInt(path[1]);		// String --> int 정수로 변환
		
		// 게시글 등록 처리 요청
		Board board = new Board("삭제된 글", "김조은" , "내용");
		// 게시글 삭제 요청
		board.setNo(no);
				
		System.out.println("삭제할 게시글 : " + board);
		Random random = new Random();
		int result = random.nextInt(2);	// 0. 1
		
		
		// 응답 처리
		// FORM 요청
//				
//		// request.getContextPath() : 최사우이 경로 (루트 컨텍스트)
//		if( result > 0)
//			// 게시글 목록으로 이동
//			response.sendRedirect(request.getContextPath() + "/board/list.jsp");
//		else 
//			// 게시글 등록으로 이동(에러메세지 포함)
//			response.sendRedirect(request.getContextPath() + "/board/update.jsp?error=FAIL");		
				
				//비동기 요청 시
				// - 등록성공
				if( result > 0)
					response.getWriter().write("SUCCESS");
				// - 등록 실패
				else
					response.getWriter().write("FATL");
					
	}

}
