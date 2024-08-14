package Mission.M11;

import java.util.Scanner;

public class Account {
	String account;
	String name;
	int money;
	
	public Account() {
		this("계좌없음", "이름없음", 0);
	}

	public Account(String account, String name, int money) {
		this.account = account;
		this.name = name;
		this.money = money;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Account [account=" + account + ", name=" + name + ", money=" + money + "]";
	}
	
	
	
	
	
	
}
