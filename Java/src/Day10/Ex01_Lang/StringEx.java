package Day10.Ex01_Lang;

import java.util.Scanner;

public class StringEx {
	public static void main(String[] args) {
		String str1 = " TheJoEun Academy ";
		String str2 = " theJoEun Academy ";
		
		System.out.println(str1.charAt(2)); // 해당 자리수 출력(영어는 소문자로)
		System.out.println(str1.concat(str2) ); // 뒤에 붙힌다
		System.out.println(str1.contains("Academy") ); // 해당문자가 있는지 (t/f)
		System.out.println(str1.equals(str2) ); //100% 같은지 대소문자 구별 (t/f)
		System.out.println(str1.equalsIgnoreCase(str2) ); // 100% 같은지 대소문자 구별X (t/f)
		System.out.println(str1.indexOf("A") ); // 해당문자 마지막 index 반환, 없으면 -1
		System.out.println(str1.lastIndexOf("e")); // 해당 문자의 마지막 index 반환, 없으면 -1
		System.out.println(str1.trim() ); // 문자열 양쪽 공백 제거
		System.out.println(str1.length() ); // 문자열 길이 (글자수) [공백포함]
		System.out.println(str1.substring(10) ); // index 앞의 문자열을 자르고, 뒤의 문자열 반환
		System.out.println(str1.substring(10,12) ); // index~(index2-1) 까지 반환
												// index 10번째 부터 16번째 까지의 문자열을 가져온다
												// Acaademy
												// [10]~[16]
		
		//split("구분자")
		String[] sp = str1.split("");//""(빈 문자열)을 기본으로 하면, 한글자씩 배열요소로 반환
		for (int i = 0; i < sp.length; i++) {
			System.out.println(i + " : \t" + sp[i]);
		}
		System.out.println();
		
		for (int i = 0; i < sp.length; i++) {
			char ch = str1.charAt(i);
			System.out.println(ch + " ");
		}
		System.out.println();
		
		//String cal = "10+20";
		
		Scanner sc = new Scanner(System.in);
		String cal = sc.nextLine();
		String[] num = cal.split("\\+");
		
		if(cal.contains("+")) {
			int a = Integer.parseInt(num[0]);
			int b = Integer.parseInt(num[1]);
			
			int result = a + b;
			System.out.println(result);
		}
		
		System.out.println("피연산자1 : " + num[0]);
		System.out.println("피연산자2 : " + num[1]);
		
		sc.close();
	}
}
