package Mission;

import java.util.Random;
import java.util.Scanner;

public class M06 {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		int[] m = new int[6];
		int key = 0;
		
		for (int i = 0; i < m.length; i++) {
			key = 0;
			while(key == 0) {
				m[i] = random.nextInt(10);
				while(true) {
					if(m[i] != 0) {
						key = 0;
						break;
					}
				}
				for (int j = 0; j < m.length; j++) {
					if(m[i] == m[j]) {
						key++;
					}
				}
			}
		}

			
			for (int j = 0; j < m.length; j++) {
				System.out.println(m[j]);
				
			}
		
	}
}
