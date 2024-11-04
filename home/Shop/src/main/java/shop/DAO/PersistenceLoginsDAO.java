package shop.DAO;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import shop.DTO.PersistenceLogins;

public class PersistenceLoginsDAO  extends JDBConnection1{

	// 토큰 생성
	public PersistenceLogins insert(String user_id) {
		int result = 0;
		String sql = " INSERT INTO persistence_logins (user_id, token, expiry_date) "
				+ " VALUES (?, ?, ?) ";
		
		// 토큰 발행
		String token = UUID.randomUUID().toString();
		// 만료 시간 설정
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 7);
		Date expiryDate = calendar.getTime();
		Timestamp expiryTime = new Timestamp(expiryDate.getTime());
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, user_id);
			psmt.setString(2, token);
			psmt.setTimestamp(3 , expiryTime);
			
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("자동 로그인 정보 등록 중, 에외 발생");
			e.printStackTrace();
		}
		System.out.println("자동 로그인 정보(토큰) 등록 성공");
		
		PersistenceLogins logins = PersistenceLogins.builder()
											.user_id(user_id)
											.token(token)
											.expiryDate(expiryDate)
											.build();
		return logins;
	}
	
	public PersistenceLogins select(String user_id) {
		
		String sql = " SELECT * "
				+ " FROM persistence_logins "
				+ " WHERE user_id = ? ";
		PersistenceLogins logins = null;
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, user_id);
			rs = psmt.executeQuery();
			if( rs.next() ) {
				logins = PersistenceLogins.builder()
										.user_id(user_id)
										.token(rs.getString("token"))
										.expiryDate(rs.getTimestamp("reg_date"))
										.regDate(rs.getTimestamp("reg_date"))
										.updDate(rs.getTimestamp("upd_date"))
										.build();
			}
			
		} catch (Exception e) {
			System.err.println("토큰 조회 시 예외 발생");
		}
		return logins;
	}
	
	
	/** 토큰 조회
	 *  - 인증 토큰으로 조회
	 * @param token
	 * @return
	 */
	public PersistenceLogins selectByToken(String token) {
		
		String sql = " SELECT * "
				+ " FROM persistence_logins "
				+ " WHERE token = ?";
		PersistenceLogins logins = null;
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, token);
			rs = psmt.executeQuery();
			if( rs.next() ) {
				logins = PersistenceLogins.builder()
										.user_id(rs.getString("user_id"))
										.token(rs.getString("token"))
										.expiryDate(rs.getTimestamp("reg_date"))
										.regDate(rs.getTimestamp("reg_date"))
										.updDate(rs.getTimestamp("upd_date"))
										.build();
			}
			
		} catch (Exception e) {
			System.err.println("토큰 조회 시 예외 발생");
		}
		return logins;
				
	}
	
	/**
	 * 토큰 수정
	 * @param user_id
	 * @return
	 */
	public PersistenceLogins update(String user_id) {
		String sql = " UPDATE persistence_logins"
				+ " SET token = ? "
				+ " ,expiry_date = ? "
				+ " ,upd_date = ? "
				+ " WHERE user_id = ? ";
		
				// 토큰 발행
				String token = UUID.randomUUID().toString();
				// 만료 시간 설정
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DAY_OF_YEAR, 7);
				Date expiryDate = calendar.getTime();
				Timestamp expiryTime = new Timestamp(expiryDate.getTime());
				
				// 수정 시간
				Timestamp updDate = new Timestamp( new Date().getTime() );
				
				PersistenceLogins logins = null;
				try {
					psmt = con.prepareStatement(sql);
					psmt.setString(1,token);
					psmt.setTimestamp(2, expiryTime);
					psmt.setTimestamp(3, updDate);
					psmt.setString(4, user_id);
					int result = psmt.executeUpdate();
					if( result > 0) {
						logins = PersistenceLogins.builder()
								.user_id(user_id)
								.token(token)
								.expiryDate(expiryDate)
								.updDate(updDate)
								.build();
						System.out.println("토큰 수정 성공!");
					}
					
				} catch (Exception e) {
					System.err.println("토큰 수정 시, 에외 발생");
					e.printStackTrace();
				}
				return logins;
	}
}
