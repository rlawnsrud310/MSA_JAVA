package shop.DAO;

import shop.DTO.Users;

public class UserDAO extends JDBConnection1{
	/**
	 * 회원가입
	 * @param user
	 * @return
	 */
	public int signup(Users user) {
		int result = 0;
		
		String sql = "INSERT INTO user(user_id, password, name, email) "
				+ "VALUES(?, ?, ?, ?) ";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, user.getUser_id());
			psmt.setString(2, user.getPassword());
			psmt.setString(3, user.getName());
			psmt.setString(4, user.getEmail());
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("회원 등록 시, 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * 회원 아이디로 조회
	 * @param user_id
	 * @return
	 */
	public Users select(String user_id) {
		String sql = "	SELECT *"
				+ "	FROM user"
				+ "	WHERE user_id = ? ";
		
		Users user = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, user_id);
			rs = psmt.executeQuery();
			if( rs.next() ) {
				user = new Users();
				//user.setNo(rs.getInt("no") );
				user.setUser_id( rs.getString("user_id") );
				user.setPassword( rs.getString("password") );
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));

			}
		} catch (Exception e) {
			System.err.println("회원 정보 아이디로 조회 시 예외 발생");
			e.printStackTrace();
		}
		
		return user;
	}
		
}
