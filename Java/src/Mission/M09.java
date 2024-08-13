package Mission;

import java.util.Scanner;

public class M09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] name = new String[100];
		int[] money = new int[100];
		

		
		for (int i = 0; i < money.length; i++) {
			name[i] = sc.next();
			if(name[i] == "QUIT") {
				System.out.println("끝");
				break;
			}
		}

		System.out.println(name[0] + money[0]);
		//System.out.println(name[1] + money[2]);

		
	}
}
