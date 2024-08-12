package test;

import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num[][] = new int[n][n];
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			int count1 = n;
			for (int j = 0; j < n; j++) {
				count++;
				num[i][j] = count;
				}
			i += 1;
			for (int j = count1-1; j >= 0; j--) {
				count++;
				if(i >= n) {
					
				}
				else {
					num[i][j] = count;	
				}
			}
		}
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				System.out.print(num[i][j] + " "); 
			}
			System.out.println();
		}
		
	}		
}

