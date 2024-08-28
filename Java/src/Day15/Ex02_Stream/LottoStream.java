package Day15.Ex02_Stream;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LottoStream {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 게임?");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			Set<Integer> set = new HashSet<Integer>();
			
			while(set.size() < 6) {
				int rand = (int) (Math.random()*45+1);
				set.add(rand);
			}
		
		set.stream()
			.sorted()
			.forEach(lotto -> System.out.print(lotto + " ") );
			System.out.println();
		}
		sc.close();
	}
}