package Day15.Ex02_Stream;

import java.util.Scanner;

public class LottoArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 게임?");
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			System.out.println("[" + (i+1) + "게임] : ");
			int lotto[] = new int[6];
			
			// 랜덤 수 6개를 대입
			for (int j = 0; j < lotto.length; j++) {
				int rand = (int) (Math.random()*45+1);
				lotto[j] = rand;
				
				//중복 제거
				for (int k = 0; k < j; k++) {
					// 현재 뽑은 랜덤 수가, 기존 수들과 같으면 다시 뽑는다.
					if(rand == lotto[k]) {
						j--;
						break;
					}
				}
			}// --랜덤수 6개 대입 끝
		
		
			// 정렬 - 선택 정렬
			for (int J = 0; J < lotto.length; J++) {
				for (int K = J+1; K < lotto.length; K++) {
					
					// 앞에 요소가 더 크면 교환 - swap
					if( lotto[J] > lotto[K]) {
						int temp = lotto[J];
						lotto[J] = lotto[K];
						lotto[K] = temp;
					}
				}
			}
			//출력
			for (int j = 0; j < lotto.length; j++) {
				System.out.print(lotto[j] + " ");
			}
			System.out.println();
	
		}
	}
}
