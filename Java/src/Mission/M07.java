package Mission;

import java.util.Scanner;

public class M07 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] a1 = new int[5];
		int[] a2 = new int[5];
		int[] b = new int[5];
		int[] c = new int[5];
		// max, min 비교변수
		int max;
		int min;
		// count 배열위치저장변수
		int count = 0;
		
		//한번입력으로 두개 배열에 저장
		for (int i = 0; i < a1.length; i++) {
			a1[i] = sc.nextInt();
			a2[i] = a1[i];
		}
		//내림차순정렬
		for(int j = 0; j < a1.length; j++) {
			max = 0;
			for(int i = 0; i< a1.length; i++) {
				if (max < a1[i]) {
					max = a1[i];
					count = i;
				}
			}
			b[j] = max;
			a1[count] = 0;
		}
		
		//오름차순정렬
		for(int j = 0; j < a2.length; j++) {
			min = 101;
			for(int i = 0; i< a2.length; i++) {
				if (min > a2[i] && a2[i] != 0) {
					min = a2[i];
					count = i;
				}
			}
			c[j] = min;
			a2[count] = 0;
		}
		
		
		
		
		//System.out.println(max + " " + count1);
		
		//테스트
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i] + " ");
		} System.out.println();
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		
	}
}
