package shop.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shop.dto.Order;
import shop.dto.Product;
import shop.dto.Ship;

public class OrderRepository extends JDBConnection {
	
	/**
	 * 주문 등록
	 * @param user
	 * @return
	 */
	public int insert(Ship ship, String user_id, String price) {
		int result = 0;
		String sql = "INSERT INTO `order` (ship_name, zip_code, country, address, date, user_id, total_price, phone)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, ship.getShipName());
			psmt.setString(2, ship.getZipCode());
			psmt.setString(3, ship.getCountry());
			psmt.setString(4, ship.getAddress());
			psmt.setString(5, ship.getDate());
			psmt.setString(6, user_id);
			psmt.setString(7, price);
			psmt.setString(8, ship.getPhone());
			result = psmt.executeUpdate();
			
		} catch (Exception e) {
			System.err.println("주문등록실패");
			e.printStackTrace();
		}
		
		
		return result;
	}

	/**
	 * 최근 등록한 orderNo 
	 * @return
	 */
	public int lastOrderNo() {
		
		return 0;
	}

	
	/**
	 * 주문 내역 조회 - 회원
	 * @param userId
	 * @return
	 */
	public List<Product> list(String userId) {
		List<Product> list = new ArrayList<Product>();
		String sql = "SELECT * FROM `order` WHERE user_id = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, userId);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Product product = new Product();
				product.setOrderNo(rs.getInt("order_no"));
				product.setUserId(rs.getString("user_id"));
				product.setUserId(rs.getString("user_id"));
				product.setUnitPrice(rs.getInt("total_price"));
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	/**
	 * 주문 내역 조회 - 비회원
	 * @param phone
	 * @param orderPw
	 * @return
	 */
	public List<Product> list(String phone, String orderPw) {
		return null;
		
	}
	
}






























