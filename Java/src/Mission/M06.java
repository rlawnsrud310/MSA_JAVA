package Mission;

import java.util.Random;
import java.util.Scanner;

public class M06 {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		int[] m = new int[6];
		//key = while종료키
		int key;
		int n = sc.nextInt();
		for (int a = 1; a < n+1; a++) {
			for (int i = 0; i < m.length; i++) {

				while (true) {
					key = 0;
					//랜덤값 설정
					m[i] = random.nextInt(45);
					//m[i] 값이 0이되면 다시 받게하는 조건문
					if (m[i] != 0) {

						//m[i] 값이 배열안에 모든수와 비교하는 반복문
						for (int j = 0; j < m.length; j++) {
							//m[i]와 비교문들이 같으면서 저장위치가 같지않는 조건문
							if (m[i] == m[j] && i != j) {
								key++;
							}
						}
					} else {
						key = 1;
					}

					if (key == 0) {
						break;
					}
				}
			}
			System.out.print("[" + a + " 게임]: ");
			for (int b = 0; b < m.length; b++) {
				System.out.print(m[b] + " ");
				
			}
			System.out.println();

		}

	}
}
