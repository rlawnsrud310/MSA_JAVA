package Day15.Ex02_Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LottoArrary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			System.out.println("[" + (i+1) + "게임] : ");
			ArrayList<Integer> l = new ArrayList<Integer>();
			
			for (int j = 0; j < 6; j++) {
				int rand = (int) (Math.random()*45+1);
				if( l.contains(rand)) j--;
				else l.add(rand);

			}
			Collections.sort(l);
			
			for (Integer integer : l) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}
}
