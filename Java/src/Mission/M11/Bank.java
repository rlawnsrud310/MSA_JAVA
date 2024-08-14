package Mission.M11;

import java.util.Scanner;


public class Bank {
	static Scanner sc = new Scanner(System.in);
	static int accnewCount = 0;
	static int money, password;
	static String accnum;
	static int temp,moneytemp = -1;
	
	static int[] pass = new int[1000];
	static Account[] acc = new Account[1000];
	
	
	//기본출력문
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
	//비밀번호 에러
	public static void passarr() {
		System.err.println("비밀번호가 다릅니다!");
	}
	//계좌번호 에러
	public static void accarr() {
		System.err.println("계좌번호가 다릅니다!");			
	}
	//100만원까지만 입금가능안내
	public static void m_100() {
		System.out.println("1회 최대 입금 금액은 100만원입니다.");
	}
	//10억원까지만 입금가능안내
	public static void m_10() {
		System.out.println("계좌잔액 최대한도는 10억입니다.");
	}
	
	//질문 출력
	public static void or() {
		System.out.println("1. 예");
		System.out.println("2. 아니오");
	}
	
	//계좌등록
	public static void newacc() {
		System.out.print("계좌번호>>");
		acc[accnewCount].setAccount(sc.next());
		System.out.print("예금주>>");
		acc[accnewCount].setName(sc.next()); 
		System.out.print("최초예금액>>");
		acc[accnewCount].setMoney(sc.nextInt());
		if(acc[accnewCount].getMoney() > 1000000) {m_100();resetacc();return;}
		System.out.print("비밀번호>>");
		pass[accnewCount] = sc.nextInt();
		System.out.println("'" + acc[accnewCount].getName() + "'님의 계좌가 개설되었습니다.");
		accnewCount++;
	}
	//계좌초기화
	public static void resetacc() {
		acc[accnewCount].setAccount("계좌없음");
	}
	//계좌번호 위치확인
	public static void comacc() {
		System.out.print("계좌번호>>");
		accnum = sc.next();
		temp = 0;
		for (int i = 0; i < acc.length; i++) {
			if(acc[i].getAccount().equals(accnum)) {
				temp = 1;
				moneytemp = i;
			}
		}
	}
	//입금, 입금출력
	public static void depmoney() {
		System.out.print("입금액>>");
		money = sc.nextInt();
		if(money > 1000001) {m_100();return;}
		System.out.println("'" + acc[moneytemp].getName() + "'님에게 입금하는게 맞으십니까?");
		or();
		int or = sc.nextInt();
		if(or == 1) {
			acc[moneytemp].setMoney(acc[moneytemp].getMoney() + money);
			if(acc[moneytemp].getMoney() >1000000001) {
				m_10();return;
			}
			System.out.println("'" + acc[moneytemp].getMoney() + "'님의 계좌에 " + money + "원이 입금되었습니다.");
		}
	}
	//출금, 출금출력
	public static void witmoney() {
		System.out.print("출금액>>");
		money = sc.nextInt();
		
		System.out.println("'" + acc[moneytemp].getName() + "'님의 계좌에 " + money + "원이 출금되었습니다.");
		acc[moneytemp].setMoney(acc[moneytemp].getMoney() - money);
	}
	//비밀번호 입력
	public static void password() {
		System.out.print("비밀번호>>");
		password = sc.nextInt();
	}
	//계좌잔액 출력
	public static void remmoney() {
		System.out.println("'" + acc[moneytemp].getName() + "'님의 계좌잔액은 " + acc[moneytemp].getMoney() + "원 입니다.");
	}
	//관리자모드 전체계좌목록 출력
		public static void admin() {
			System.out.print("관리자 비밀번호>>");
			int admin = sc.nextInt();
			if(admin == 1111) {
				for (int i = 0; i < acc.length; i++) {
					if(acc[i].getAccount().equals("계좌없음")) {
						break;
					}
					System.out.println("==========계좌목록==========");
					System.out.println("예금주			계좌번호				잔고");
					System.out.println(acc[i]);
				}
			}
			else {
				passarr();
			}
		}
		
	public static void main(String[] args) {

		for (int i = 0; i < acc.length; i++) {
			acc[i] = new Account("계좌없음","이름없음",0);			
		}

		while(true) {
			Basic();
			System.out.print("입력>>");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				newacc();
				break;
			case 2:
				comacc();
				//계좌번호 잘못입력시 잘못입력안내 및 처음화면
				if(temp == 1) {}
				else {accarr();break;}
				depmoney();
				break;
			case 3:
				comacc();
				//계좌번호 잘못입력시 잘못입력안내 및 처음화면
				if(temp == 1) {}
				else {accarr();break;}
				password();
				//비밀번호 잘못입력시 잘못입력안내 및 처음화면
				if(pass[moneytemp] == password) {}
				else {passarr();break;}
				witmoney();
				break;
			case 4:
				comacc();
				//계좌번호 잘못입력시 잘못입력안내 및 처음화면
				if(temp == 1) {}
				else {accarr();break;}
				password();
				//비밀번호 잘못입력시 잘못입력안내 및 처음화면
				if(pass[moneytemp] == password) {}
				else {passarr();break;}
				remmoney();	
				break;
			case 5:
				admin();
				break;
			case 6:
				break;

			default:
				break;
			}
			if(num == 6) {break;}
		}	
		System.out.println("시스템을 종료합니다.");
	}
}
