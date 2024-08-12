package Mission;

import java.util.Scanner;

public class M02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] x = new int[n/2];
		int[] y = new int[n/2];
		
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int sum1=0,sum2=0;
		
		for (int i = 1; i < n+1; i++) {
			//홀수
			if(i % 2 == 1) {
				x[count1] = i;
				//System.out.print(i + "x");
				sum1 += x[count1];
				count1++;
			}
			//짝수
			else {
				y[count2] = i;
				sum2 += y[count2];
				//System.out.print(i + "y");
				count2++;
			}
			//약수배열크기
			if(n % i == 0) {
				count3++;
			}
			
		}
		
		//System.out.println();
		// 약수 출력
		int[] z = new int[count3];
		count3 = 0;
		for (int i = 1; i < n+1; i++) {
			if(n % i == 0) {
				z[count3] = i;
		//		System.out.print(i + " ");
				count3++;
			}
		}
		for (int j = 0; j < x.length; j++) {
			if(j < x.length-1) {
				System.out.print(x[j] + "+");
			}
			else {
				System.out.print(x[j] + "=");
			}
		}
		System.out.println(sum1);
		for (int j = 0; j < y.length; j++) {
			if(j < y.length-1) {
				System.out.print(y[j] + "+");
			}
			else {
				System.out.print(y[j] + "=");
			}
		}
		System.out.println(sum2);

		for (int i = 0; i < z.length; i++) {
			System.out.print(z[i] + " ");
		}
	}
}
