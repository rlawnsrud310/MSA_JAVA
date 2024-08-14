package Mission;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class M12 {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();

		Scanner sc = new Scanner(System.in);
		System.out.print("몇게임? ");
		int n = sc.nextInt();
		int count,r;

		for (int j = 1; j <= n; j++) {
			System.out.print("(" + j + "번 게임) : ");
			for (int i = 0; i < 6; i++) {
				while(true){
					a.add((int) (Math.random() * 45) + 1);
					r = a.get(i);
					count = 0;
					for(Integer c : a) {
						if(r==c) {
							count++;
						}
					}
					if(count == 2) {a.remove(i);}
					else {
						break;						
					}
				}
			}
			
			a.sort(Comparator.naturalOrder());
			System.out.println(a);
			a.removeAll(a);
		}

		

	}
}
