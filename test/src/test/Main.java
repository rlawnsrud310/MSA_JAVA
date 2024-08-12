package test;

import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int[] a = new int[n1];
		int c = 0;
		
		for (int i = 0; i < a.length; i++) {
			int m = sc.nextInt();
			
			a[i] = m;
		}
		int n2 = sc.nextInt();
		for (int i = 0; i < n2; i++) {
			c = 0;
			int m = sc.nextInt();
			for (int j = 0; j < a.length; j++) {
				if(a[j] == m) {
					c = 1;
				}
			}
			System.out.print(c + " ");
		}
		sc.close();
	}		
}

