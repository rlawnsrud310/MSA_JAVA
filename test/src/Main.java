import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] a = new int[19][19];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		int n = sc.nextInt();
		int[][] b = new int[n][n];
		
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; i < b[i].length; j++) {
				b[i-1][j-1] = sc.nextInt();
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
		/*
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if() {
					a[i][j] = 1;										
				}
				else {
					a[i][j] = 0;					
				}
			}
		}*/
		
		/*
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		*/
		
	}
}
