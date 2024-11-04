package shop.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
 
public class JDBConnection1 {
	
	public Connection con;	
	public Statement stmt;			
	public PreparedStatement psmt;		
	public ResultSet rs;				
	
	// 기본 생성자
	public JDBConnection1() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");		 

			String url = "jdbc:mysql://127.0.0.1:3306/joeun?serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true&useSSL=false";
			String id = "joeun";
			String pw = "123456";
			

			con = DriverManager.getConnection(url, id, pw);
			
			System.out.println("DB 연결 성공");
		} catch (Exception e) {
			System.err.println("DB 연결 실패");
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		JDBConnection1 jdbc = new JDBConnection1();
	}

}