package Day07.Review;

import java.util.Scanner;

public class Ex05_Matrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		int count = 1;

		int[][] a = new int[m][n];
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = count;
				count++;
				System.out.print(a[i][j] +" ");
			}
			System.out.println();
		}
	}
}
