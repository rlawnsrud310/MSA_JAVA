import java.util.Scanner;

public class Upcodeerr1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] a = new int[19][19];
		//바둑판제작
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		int n = sc.nextInt();
		int[][] b = new int[n][n];
		//조건발생
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				b[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {

				// 비교문
				for (int i1 = 0; i1 < b.length; i1++) {
					for (int i2 = 0; i2 < b[i1].length; i2++) {
						
						if(i == b[i1][i1] && j == b[i2][i2]) {
							a[i-1][j-1] = 1;
						}
						else {
							a[i][j] = 0;							
						}
					}
				}

			}
		}
		
		//출력문
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}

	}
}