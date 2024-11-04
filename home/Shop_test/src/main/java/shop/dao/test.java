package shop.dao;

import shop.dto.User;

public class test {

	public static void main(String[] args) {
		UserRepository user = new UserRepository();
		User use = user.login("1234", "1111");
		/* User use = user.getUserById("1234"); */
		
		
		System.out.println(use.getNo());
		System.out.println(use.getId());
		System.out.println(use.getPassword());
		System.out.println(use);
		
		
		
	}

}
