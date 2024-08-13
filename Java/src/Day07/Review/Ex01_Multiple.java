package Day07.Review;

import java.util.Scanner;

public class Ex01_Multiple {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		if(n % 3 == 0) {
			System.out.println("3의 배수입니다");
		}
		else {
			System.out.println("3의 배수가 아닙니다.");			
		}
	}
}
