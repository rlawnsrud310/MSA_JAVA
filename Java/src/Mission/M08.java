package Mission;

import java.util.Scanner;

public class M08 {
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
			//num[i][끝] 뒤에서부터 저장
			i += 1;
			for (int j = count1-1; j >= 0; j--) {
				count++;
				//마지막줄초과될때 반복문 종료
				if(i >= n) {
					break;
				}
				else {
					num[i][j] = count;	
				}
			}
		}
		
		//출력
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				System.out.print(num[i][j] + " "); 
			}
			System.out.println();
		}
	}
}
