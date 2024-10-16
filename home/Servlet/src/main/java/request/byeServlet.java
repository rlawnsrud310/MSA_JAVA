package request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class byeServlet
 */
@WebServlet("/bye")
public class byeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public byeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset:UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int dice = (int)(Math.random() * 6 + 1);
		// PrintWriter 객체를 사용하여 HTML 응답을 생성
		PrintWriter writer = response.getWriter();
		//콘솔 출력이 아닌 클라이언트로 응답을 출력
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>HTML 응답 생성</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>Bye Servelt~!</h1>");
		writer.println("<h3>주사위 번호 : " + dice + "</h3>");
		writer.println("</body>");
		writer.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		
	}

}
