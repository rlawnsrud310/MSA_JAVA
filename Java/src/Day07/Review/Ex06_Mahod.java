package Day07.Review;

import java.util.Scanner;

public class Ex06_Mahod {
	public static int plus(int a, int b) {
		int result = a + b;
		return result;
	}
	public static int minus(int a, int b) {
		int result = a - b;
		return result;
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(a + " + "+ b + " = "+plus(a,b));
		System.out.println(a + " - "+ b + " = "+minus(a,b));
	}
	
}
