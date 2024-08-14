package Day07.Review;

import java.util.Scanner;

public class Ex04_Lotto {
	public static void main(String[] args) {
		double random = Math.random();
		int[] a = new int[6];
		int[] b = new int [6];
	//	System.out.println((int)(Math.random()*45)+1);
		Scanner sc = new Scanner(System.in);
		System.out.print("몇게임? ");
		int n = sc.nextInt();		
		
		int count = 0;
		int min;
		
		for (int j = 1; j <= n; j++) {
			System.out.print("("+ j + "번 게임) : ");
			for (int i = 0; i < a.length; i++) {
				//중복제거
				while(true) {
					count = 0;
					a[i] = (int)(Math.random()*45)+1;
					for(int c = 0; c < a.length; c++) {
						if(a[i] == a[c] && i != c) {
							count = 1;
						}
					}	if(count == 0) {break;}
				}									
			}
			//오름차순
			for(int k = 0; k < a.length; k++) {
				min = 46;
				for(int i = 0; i< a.length; i++) {
					if (min > a[i] && a[i] != 0) {
						min = a[i];
						count = i;
					}
				}
				b[k] = min;
				a[count] = 0;
			}
			
			for (int ii = 0; ii< b.length;ii++ ) {
				System.out.print(b[ii] + " ");	
			}
			
			System.out.println();
		}

	}
}
