package Day10.Ex02_utill;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenizerSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		
		StringTokenizer st = new StringTokenizer(a,"+");
		
		int[] b = new int[st.countTokens()];
		int i = 0,sum = 0;
		while( st.hasMoreTokens()) {		// 다음 토큰이 있으면 반복
			
			b[i] = Integer.parseInt(st.nextToken());
			sum += b[i];
			i++;
		}
		System.out.println(sum);
	}
}
