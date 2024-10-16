package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class file
 */
@WebServlet("/upload")
// 파일 업로드를 처리하기 위한 어노테이션
@MultipartConfig(
		fileSizeThreshold = 1 * 1024 * 1024,// 파일 초과 시 임시 메모리
		maxFileSize = 10 * 1024 *1024,		// 파일당 최대 크기
		maxRequestSize = 50*1024*1024		// 요청당 최대 크기 ( 5개의 * 10MB
		)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// 업로드 경로
		//String applicationPath = request.getServletContext().getRealPath("");
		
		// 업로드 폴더가 없으면 폴더 생성
		String uploadPath = "C:\\fileupload";
		
		File uploadDir = new File(uploadPath);
		if( !uploadDir.exists() ) {
			uploadDir.mkdir();
		}
		
		// 클라이언트에서 전송한 파일 가져오기
		Part filePart = request.getPart("file");
		// 파일 이름
		String fileName = Paths.get( filePart.getSubmittedFileName() ).getFileName().toString();
		// C:/fileupload/강아지.jpg
		String filePath = uploadPath + File.separator + fileName;
		
		// 파일 저장
		try {
			InputStream is = filePart.getInputStream();
			long result = Files.copy(is, Paths.get(filePath));
			System.out.println("파일 복사 결과 : " + result);
		} catch (Exception e) {
			System.out.println("파일 복사 중 에러 발생");
			e.printStackTrace();
		}
		
	}

}
