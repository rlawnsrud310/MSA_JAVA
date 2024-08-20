package Day10.Ex01_Lang;

public class MathEx {
	public static void main(String[] args) {
		System.out.println(Math.PI);			// 3.141592653589793 (원주율)
		System.out.println(Math.E);				// 2.718281828459045 (자연상수)
		System.out.println(Math.ceil(3.125));	// 올림 : 해당 수보다 큰 정수 중 가장 작은수
		System.out.println(Math.floor(3.75));	// 내림 : 해당 수보다 작은 정수중 가장 큰 수
		System.out.println(Math.sqrt(9));		// 제곱근
		System.out.println(Math.pow(3, 2));		// 3의 2제곱
		System.out.println(Math.exp(2));		// e의 2승
		System.out.println(Math.round(3.14));	// 반올림
		System.out.println("-------------------");
		
		// 로또 번호
		// Math.random()			: 0.0 보다 크거나 같고 1.0 보다 작은 임의의 실수
		// Math.random()			: 0.0xxx~0.9xxx
		// (0.0xxx~0.9xxx) * 10 	: 0.xxx~9.xxx	(0 ~ 9)		-10개
		// (0.0xxx~0.9xxx) * 20 	: 0.xxx~19.xxx	(0 ~ 19)	-20개
		// (int)(Math.random() * 45 + 1) : 1~45
		
		int lotto[] = new int[6];
		for (int i = 0; i < 6; i++) {
			int random = (int)(Math.random() * 45 + 1);
			lotto[i] = random;
			// 중복 제거
			for (int j = 0; j < i; j++) {
				// 중복이 되는 경우
				if( lotto[j] == random) {
					i--;
				}
			}
		}
		
		for (int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i] + " ");
		}
	}
}
