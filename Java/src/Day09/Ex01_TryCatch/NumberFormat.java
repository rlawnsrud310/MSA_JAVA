package Day09.Ex01_TryCatch;
/**
 *  예외 처리
 *  NumberFormatException
 *   : 문자열 숫자("10")가 아닌 문자열을 숫자타입으로 변환 시 발생하는 예외 상황
 *   ex) "10A" --> 숫자로 변환하면 예외
 */
public class NumberFormat {
	public static void main(String[] args) {
		String strNum = "10";
		int num = 10;
		
		System.out.println("10 + 20 = " + (strNum + 20));
		System.out.println("10 + 20 = " + (num + 20));
		
		//Integer.parseInt("문자열숫자")
		// : 문자열 숫자를 int 타입의 숫자로 변환하는 메소드
		String numberString = "10";
		String numberAndString = "A10";
		int num1 = Integer.parseInt(numberString);
		System.out.println("numberString + 5 = "+(numberString+5));
		
		int num2 = 0;
		//java.lang.NumberFormatException
		
		try {
			num2 = Integer.parseInt(numberAndString);			
		} catch (NumberFormatException e) {
			System.err.println("문자열숫자가 아닌 문자열을 숫자타입으로 변환할 수 없습니다.");
		}
		
		System.out.println("num10 : " + (num1+10));
		System.out.println("num2 : " + num2);
		
	
	
	
	}
}
