package Day10.Ex02_utill;

import java.util.Random;

public class RandomEx {
	public static void main(String[] args) {
		Random random = new Random();
		
		// 동전 던지기
		boolean randomTF = random.nextBoolean();
		System.out.println("동전 앞뒤 : " + randomTF);
		
		System.out.println("동전 던지기");
		if(randomTF) System.out.println("앞면");
		else System.out.println("뒷면");
		
		// 정수형 랜덤 수
		int fourByteRandom = random.nextInt();
		System.out.println("fourByteRandom : " + fourByteRandom);
		
		//주사위 던지기
		int dice = random.nextInt(6) + 1;
		System.out.println("주사위 : " + dice);
		
		// 로또
		int lotto = random.nextInt(45) + 1;
		System.out.println("로또번호 : " + lotto);
		
		// 실수형 랜덤 수
		double randomDouble = random.nextDouble();
		System.out.println("randomDouble : " + randomDouble
				);
		
		
	}
}
