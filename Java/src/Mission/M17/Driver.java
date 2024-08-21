package Mission.M17;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		RemoteControl drone = new Drone();
		RemoteControl rcCar = new RcCar();
		Scanner sc = new Scanner(System.in);
		
		int n,m;
		int rcpow = 0, dropow = 0;
		int speed;
		
		
		do {
			System.out.println("::::: RcCAr or Drone :::::");
			System.out.println("1. RcCar");
			System.out.println("2. Drone");
			System.out.println("0. 종료");
			System.out.print("번호 입력 : ");
			n = sc.nextInt();
			
			//RcCar 메뉴
			while(n == 1) {
				System.out.println("::::: RcCar 메뉴 :::::");
				System.out.println("1. 전원 On");
				System.out.println("2. 전원 Off");
				System.out.println("3. 속도조절");
				System.out.println("4. 배터리교체");
				System.out.println("0. RcCar/Drone 선택창 돌아가기");
				System.out.print("번호 입력 : ");
				m = sc.nextInt();
				
				switch (m) {
				case 0:
					n = 100;
					break;
				case 1:
					rcpow = 1;
					rcCar.on();
					break;
				case 2:
					if(rcpow == 0) {
						System.out.println("이미 전원이 꺼져있습니다.");break;
					}
					rcpow = 0;
					rcCar.off();
					break;
				case 3:
					if(rcpow == 0) {System.out.println("전원이 꺼져있습니다.");break;}
					System.out.print("속도 : ");
					speed = sc.nextInt();
					rcCar.setSpeed(speed);
					break;
				case 4:
					if(rcpow == 0) {System.out.println("전원이 꺼져있습니다.");break;}
					rcCar.changeBattery();
					break;	
				default:
					break;
				}
				
				System.out.println(":::::::::::::::::::::");
				
			} //RcCar 메뉴 종료
			
			//Drone 메뉴
			while(n == 2) {
				System.out.println("::::: Drone 메뉴 :::::");
				System.out.println("1. 전원 On");
				System.out.println("2. 전원 Off");
				System.out.println("3. 속도조절");
				System.out.println("4. 배터리교체");
				System.out.println("0. RcCar/Drone 선택창 돌아가기");
				System.out.print("번호 입력 : ");
				m = sc.nextInt();
				
				switch (m) {
				case 0:
					n = 100;
					break;
				case 1:
					dropow = 1;
					drone.on();
					break;
				case 2:
					if(dropow == 0) {
						System.out.println("이미 전원이 꺼져있습니다.");break;
					}
					dropow = 0;
					drone.off();
					break;
				case 3:
					if(dropow == 0) {System.out.println("전원이 꺼져있습니다.");break;}
					System.out.print("속도 : ");
					speed = sc.nextInt();
					drone.setSpeed(speed);
					break;
				case 4:
					if(dropow == 0) {System.out.println("전원이 꺼져있습니다.");break;}
					drone.changeBattery();
					break;	
				default:
					break;
				}
				
				System.out.println(":::::::::::::::::::::");
				
			}// Drone 메뉴종료
			
			
		}while(n != 0);
		
		System.out.println("RemoteControl이 종료되었습니다.");
		sc.close();
	}
}
