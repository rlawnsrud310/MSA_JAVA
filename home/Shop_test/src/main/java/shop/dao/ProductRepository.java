package shop.dao;

import java.util.ArrayList;
import java.util.List;

import shop.dto.Product;


public class ProductRepository extends JDBConnection {
	
	/**
	 * 상품 목록
	 * @return
	 */
	public List<Product> list() {
		List<Product> productList = new ArrayList<Product>();
		
		String sql = "SELECT * FROM product ";
		
		try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Product product = new Product();
				
				product.setProductId(rs.getString("product_id"));
				product.setName(rs.getString("name"));;
				product.setUnitPrice(rs.getInt("unit_price"));;
				product.setDescription(rs.getString("description"));;
				product.setManufacturer(rs.getString("manufacturer"));
				product.setCategory(rs.getString("category"));
				product.setUnitsInStock(rs.getLong("units_in_stock"));
				product.setCondition(rs.getString("condition"));;
				product.setFile(rs.getString("file"));
				// 안쓴거 quantity 장바구니 개수
				productList.add(product);
			}
			
		} catch (Exception e) {
			System.err.println("리스트 목록 출력오류");
			e.printStackTrace();
		}
		
		return productList;
		
	}
	
	
	/**
	 * 상품 목록 검색
	 * @param keyword
	 * @return
	 */
	public List<Product> list(String keyword) {
		List<Product> productList = new ArrayList<Product>();
		keyword = "%" + keyword + "%";
		System.out.println(keyword);
		
		String sql = "SELECT * FROM product "
		           + "WHERE name LIKE ? "
		           + "OR description LIKE ? "
		           + "OR manufacturer LIKE ? "
		           + "OR category LIKE ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, keyword);
			psmt.setString(2, keyword);
			psmt.setString(3, keyword);
			psmt.setString(4, keyword);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Product product = new Product();
				
				product.setProductId(rs.getString("product_id"));
				product.setName(rs.getString("name"));;
				product.setUnitPrice(rs.getInt("unit_price"));;
				product.setDescription(rs.getString("description"));;
				product.setManufacturer(rs.getString("manufacturer"));
				product.setCategory(rs.getString("category"));
				product.setUnitsInStock(rs.getLong("units_in_stock"));
				product.setCondition(rs.getString("condition"));;
				product.setFile(rs.getString("file"));
				// 안쓴거 quantity 장바구니 개수
				productList.add(product);
			}
			
		} catch (Exception e) {
			System.err.println("리스트 목록 출력오류");
			e.printStackTrace();
		}
		
		return productList;
	}
	
	/**
	 * 상품 조회
	 * @param productId
	 * @return
	 */
	public Product getProductById(String productId) {
		Product product = new Product();
		
		String sql = "SELECT * FROM product WHERE product_id = ? ";
		
		try {
			
			psmt = con.prepareStatement(sql);
			psmt.setString(1, productId);
			rs = psmt.executeQuery();
			
	
			
			
			if(rs.next()) {
				product.setProductId(rs.getString("product_id"));
				product.setName(rs.getString("name"));;
				product.setUnitPrice(rs.getInt("unit_price"));;
				product.setDescription(rs.getString("description"));;
				product.setManufacturer(rs.getString("manufacturer"));
				product.setCategory(rs.getString("category"));
				product.setUnitsInStock(rs.getLong("units_in_stock"));
				product.setCondition(rs.getString("condition"));;
				product.setFile(rs.getString("file"));
			}
			
		} catch (Exception e) {
			System.err.println("아이디 검색 실패");
			e.printStackTrace();
		}
		
		
		return product;
		
	}
	
	
	/**
	 * 상품 등록
	 * @param product
	 * @return
	 */
	public int insert(Product product) {
		int result = 0;
		
		String sql = "INSERT INTO product (product_id, name, unit_price, description, manufacturer, category, units_in_stock, `condition`, file)"
			+	 "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, product.getProductId());
			psmt.setString(2, product.getName());
			psmt.setInt(3, product.getUnitPrice());
			psmt.setString(4, product.getDescription());
			psmt.setString(5, product.getManufacturer());
			psmt.setString(6, product.getCategory());
			psmt.setLong(7, product.getUnitsInStock());
			psmt.setString(8, product.getCondition());
			psmt.setString(9, product.getFile());
			result = psmt.executeUpdate();
			
			
		} catch (Exception e) {
			System.err.println("등록 오류");
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	/**
	 * 상품 수정
	 * @param product
	 * @return
	 */
	public int update(Product product) {
		int result = 0;
		
		String sql = "UPDATE product "
				+ " SET name = ?"
				+ ", unit_price = ?"
				+ ", description = ?"
				+ ", manufacturer = ?"
				+ ", category = ?"
				+ ", units_in_stock = ?"
				+ ", `condition` = ?"
				+ ", file = ?"
				+ " WHERE product_id = ?";
			try {
				psmt = con.prepareStatement(sql);
				psmt.setString(1, product.getName());
				psmt.setInt(2, product.getUnitPrice());
				psmt.setString(3, product.getDescription());
				psmt.setString(4, product.getManufacturer());
				psmt.setString(5, product.getCategory());
				psmt.setLong(6, product.getUnitsInStock());
				psmt.setString(7, product.getCondition());
				psmt.setString(8, product.getFile());
				psmt.setString(9, product.getProductId());
				result = psmt.executeUpdate();
			} catch (Exception e) {
				System.err.println("상품 업뎃 오류!");
				e.printStackTrace();
			}
		
		return result;
	}
	
	
	
	/**
	 * 상품 삭제
	 * @param product
	 * @return
	 */
	public int delete(String productId) {
		int result = 0;
		String sql = "DELETE FROM product WHERE product_id = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, productId);
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("상품 삭제 에러");
			e.printStackTrace();
		}
		return result;
	}
	
	public int quantityplus(String id) {
		int result = 0;
		String sql = "UPDATE product SET quantity = quantity + 1 WHERE product_id = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("장바구니 추가 에러");
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<Product> list2() {
		List<Product> productList = new ArrayList<Product>();
		
		String sql = "SELECT * FROM product WHERE quantity >= 1 ";
		
		try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Product product = new Product();
				
				product.setProductId(rs.getString("product_id"));
				product.setName(rs.getString("name"));;
				product.setUnitPrice(rs.getInt("unit_price"));;
				product.setDescription(rs.getString("description"));;
				product.setManufacturer(rs.getString("manufacturer"));
				product.setCategory(rs.getString("category"));
				product.setUnitsInStock(rs.getLong("units_in_stock"));
				product.setCondition(rs.getString("condition"));;
				product.setQuantity(rs.getInt("quantity"));
				// 안쓴거 quantity 장바구니 개수
				productList.add(product);
			}
			
		} catch (Exception e) {
			System.err.println("리스트 목록 출력오류");
			e.printStackTrace();
		}
		
		return productList;
		
	}
	
	public int total() {
	    int result = 0;
	    String sql = "SELECT SUM(quantity) AS total FROM product WHERE quantity >= 1";
	    
	    try {
	    	stmt = con.createStatement();
	    	rs = stmt.executeQuery(sql);
	        if (rs.next()) {
	            result = rs.getInt("total");
	            if (rs.wasNull()) { // 총합이 null인 경우
	                result = 0;
	            }
	        }
	    } catch (Exception e) {
	        System.err.println("장바구니 에러");
	        e.printStackTrace();
	    }
	    
	    return result;
	}
	
	public void resetQuantityToZero() {
	    String sql = "UPDATE product SET quantity = 0";

	    try  {
	    	stmt = con.createStatement();
	        int rowsUpdated = stmt.executeUpdate(sql);
	        System.out.println("Updated rows: " + rowsUpdated);
	    } catch (Exception e) {
	        System.err.println("수량 초기화 에러");
	        e.printStackTrace();
	    }
	}
	
	public void resetQuantityToZeroById(String productId) {
	    String sql = "UPDATE product SET quantity = 0 WHERE product_id = ?";

	    try {
	    	psmt = con.prepareStatement(sql);
	        psmt.setString(1, productId); // product_id에 값 설정
	        int rowsUpdated = psmt.executeUpdate();
	        System.out.println("Updated rows: " + rowsUpdated);
	    } catch (Exception e) {
	        System.err.println("수량 초기화 에러");
	        e.printStackTrace();
	    }
	}
}





























