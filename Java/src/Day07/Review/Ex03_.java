package Day07.Review;

import java.util.Scanner;

	public class Ex03_ {
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
			
			
			System.out.println("실명  출장비  오만원  만원  오천원  천원  오백원  백원  오십원   십원   오원   일원");
			for (int i = 0; i < name.length; i++) {
				int _50000,_10000,_5000,_1000,_500,_100,_50,_10,_5,_1;
				int _money = 0;
				if(name[i] == null) {
					break;
				}
				
				System.out.print(name[i] + " ");
				System.out.print(money[i] + " ");
				
				_50000 = (money[i] / 50000);
				_money = money[i]-(_50000 * 50000);
				_10000 = _money / 10000;
				_money = _money - (_10000 * 10000);
				_5000 = _money / 5000;
				_money = _money - (_5000 * 5000);
				_1000 = _money / 1000;
				_money = _money - (_1000 * 1000);
				_500 = _money / 500;
				_money = _money - (_500 * 500);
				_100 = _money / 100;
				_money = _money - (_100 * 100);
				_50 = _money / 50;
				_money = _money - (_50 * 50);
				_10 = _money / 10;
				_money = _money - (_10 * 10);
				_5 = _money / 5;
				_money = _money - (_5 * 5);
				_1 = _money / 1;
				_money = _money - (_1 * 1);
				
				sum[0] += _50000;
				sum[1] += _10000;
				sum[2] += _5000;
				sum[3] += _1000;
				sum[4] += _500;
				sum[5] += _100;
				sum[6] += _50;
				sum[7] += _10;
				sum[8] += _5;
				sum[9] += _1;
				
				
				
				System.out.println( _50000 + "    " + _10000 + "     " + _5000 + "      " + _1000 + "    " + _500 + "    " + _100 + "     " + _50 + "     " + _10 + "    " + _5 + "    " + _1);
			}
			
			System.out.print("전체 화폐매수 : ");
			for (int i = 0; i < sum.length; i++) {
				System.out.print(sum[i] + "    ");
			}
		}
	}

