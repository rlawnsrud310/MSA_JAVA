package Mission;

import java.util.Scanner;

public class M04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//a = 줄수 입력
		int a = sc.nextInt();
		//count = 별한개부터 홀수로 하기위해 초기값 -1 입력 이후 +2 -> 1,3,5,7....
		int count = -1;
		// g = 띄어쓰기 수
		int g = a-1;

		for(int n = 0; n < a; n++) {
			count =  count + 2;
			//띄어쓰기 생성
			for(int j = g; j >= 1; j--) {
				System.out.print(" ");
			}
			g--;
			//별생성
			for(int i = 0; i < count; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}
}
