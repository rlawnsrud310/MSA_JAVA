package Mission.M11;

import java.util.Scanner;


public class Bank {
	
	public static void Basic() {
		System.out.println("===================================");
		System.out.println("1.	계좌등록");
		System.out.println("2.	입금");
		System.out.println("3.	출금");
		System.out.println("4.	계좌조회");
		System.out.println("5.	계좌목록");
		System.out.println("6.	종료");
		System.out.println("===================================");
	}
	
	public static void passarr() {
		System.err.println("비밀번호가 다릅니다!");
	}
	public static void accarr() {
		System.err.println("계좌번호가 다릅니다!");			
	}
	
	public static void or() {
		System.out.println("1. 예");
		System.out.println("2. 아니오");
	}
	

	public static void main(String[] args) {
		

		
		int accnewCount = 0;
		int money, password;
		String accnum;
		int temp,moneytemp = -1;
		
		int[] pass = new int[1000];
		Account[] acc = new Account[1000];
		Scanner sc = new Scanner(System.in);
		
		
		for (int i = 0; i < acc.length; i++) {
			acc[i] = new Account("계좌없음","이름없음",0);			
		}
		
		
		
		
		while(true) {
			Basic();
			System.out.print("입력>>");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				System.out.print("계좌번호>>");
				acc[accnewCount].account = sc.next(); 
				System.out.print("예금주>>");
				acc[accnewCount].name = sc.next(); 
				System.out.print("최초예금액>>");
				acc[accnewCount].money = sc.nextInt();
				System.out.print("비밀번호>>");
				pass[accnewCount] = sc.nextInt();
				System.out.println("'" + acc[accnewCount].name + "'님의 계좌가 개설되었습니다.");
				accnewCount++;
				break;
			case 2:
				System.out.print("계좌번호>>");
				accnum = sc.next();
				temp = 0;
				for (int i = 0; i < acc.length; i++) {
					if(acc[i].account.equals(accnum)) {
						temp = 1;
						moneytemp = i;
					}
				}
				//계좌번호 잘못입력시 잘못입력안내 및 처음화면
				if(temp == 1) {}
				else {accarr();break;}
				
				System.out.print("입금액>>");
				money = sc.nextInt();
				System.out.println("'" + acc[moneytemp].name + "'님에게 입금하는게 맞으십니까?");
				or();
				int or = sc.nextInt();
				if(or == 1) {
					System.out.println("'" + acc[moneytemp].name + "'님의 계좌에 " + money + "원이 입금되었습니다.");
					acc[moneytemp].money = acc[moneytemp].money + money;
				}
				
				break;
			case 3:
				System.out.println("계좌번호>>");
				accnum = sc.next();
				for (int i = 0; i < acc.length; i++) {
					if(acc[i].account.equals(accnum)) {
						temp = 1;
						moneytemp = i;
					}
				}
				System.out.println("비밀번호>>");
				password = sc.nextInt();
				
				if(pass[moneytemp] == password) {}
				else {passarr();break;}
				
				System.out.println("출금액>>");
				money = sc.nextInt();
				break;
			case 4:
				break;
			case 5:
				System.out.print("관리자 비밀번호>>");
				int admin = sc.nextInt();
				if(admin == 1111) {
					for (int i = 0; i < acc.length; i++) {
						if(acc[i].account.equals("계좌없음")) {
							break;
						}
						System.out.println(acc[i]);
					}
				}
				else {
					passarr();
				}
				break;
			case 6:
				break;

			default:
				break;
			}
			if(num == 6) {break;}
		}
		System.out.println(acc[0]);
		
	}
}
