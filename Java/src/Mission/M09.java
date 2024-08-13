package Mission;

import java.util.Scanner;

public class M09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] name = new String[100];
		int[] money = new int[100];
		
		int count = 0;

		while(true) {	
			name[count] = sc.next();
			if(name[count].equals("QUIT")) {
				name[count] = null;
				break;}
			
			money[count] = sc.nextInt();
			
			count++;
		}

		
		int[] sum = new int[10];
		int[] won = new int[10];
		int don = 50000;
		
		
		System.out.println("실명  출장비  오만원  만원  오천원  천원  오백원 백원 오십원 십원  오원  일원");
		for (int i = 0; i < name.length; i++) {
			int _money = 0;
			if(name[i] == null) {
				break;
			}
			
			System.out.print(name[i] + " ");
			System.out.print(money[i] + " ");
			
			for (int j = 0; j < won.length; j++) {
				if(don == 50000) {
					won[j] = (money[i]/don);
					_money = money[i] - (won[j] * don);
				}
				else {
					won[j] = (_money / don);
					_money = _money - (won[j] * don);
				}
				sum[j] += won[j];
				
				
				if(don == 50000 || don == 5000 || don == 500 || don == 50 || don == 5) {
					don = don / 5;
				}
				else {
					don = don / 2;
				}	
			}
			don = 50000;
			
			for (int a = 0; a < won.length; a++) {
				System.out.print(won[a] + "    ");
			}
			System.out.println();
		}
		
		System.out.print("전체 화폐매수 : ");
		for (int i = 0; i < sum.length-1; i++) {
			System.out.print(sum[i] + "   ");
		}
		System.out.print("  "+sum[9]);
	}
}
