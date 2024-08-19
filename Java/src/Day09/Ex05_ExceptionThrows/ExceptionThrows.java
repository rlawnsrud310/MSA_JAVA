package Day09.Ex05_ExceptionThrows;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionThrows {
	
	static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		try {
			// input() 메소드에서 예외를 전가해서
			// 호출한 곳에서 예외처리를 해야한다.
			input();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("정수를 입력해주세요");
		}
	}
	
	public static void input() throws InputMismatchException{
		System.out.print("입력 : ");
		int input = sc.nextInt(); //예외 발생 가능성 코드
		System.out.println(input);
	}
}
