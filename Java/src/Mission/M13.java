package Mission;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class M13 {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("몇게임? ");
		int n = sc.nextInt();
		ArrayList<Integer>[] b = new ArrayList[n];
		int[] aute = new int[n];
		int count, r;
		int j;
		for (j = 1; j <= n; j++) {
			System.out.print("[" + j + " 게임] (1.자동 / 2.수동)");
			int n1 = sc.nextInt();
			aute[j-1] = n1;
			if (n1 == 1) {
				for (int i = 0; i < 6; i++) {
					while (true) {
						a.add((int) (Math.random() * 45) + 1);
						r = a.get(i);
						count = 0;
						for (Integer c : a) {
							if (r == c) {
								count++;
							}
						}
						// 배열에 저장한 랜덤값이 모든자리 값이랑 비교할때 같은자리에 값을 한번은 지나가니
						// 두번 카운팅되면 해당값 지우고 다시 랜덤값 받아옴
						if (count == 2) {
							a.remove(i);
						} else {
							break;
						}
					}
				}
			} else if (n1 == 2) {
				System.out.print("① : ");
				a.add(sc.nextInt());
				System.out.print("② : ");
				a.add(sc.nextInt());
				System.out.print("③ : ");
				a.add(sc.nextInt());
				System.out.print("④ : ");
				a.add(sc.nextInt());
				System.out.print("⑤ : ");
				a.add(sc.nextInt());
				System.out.print("⑥ : ");
				a.add(sc.nextInt());

			}
			// 오름차순 정렬
			a.sort(Comparator.naturalOrder());
			for (int i = 0; i < 6; i++) {
				System.out.print(a.get(i) + " ");
			}
			System.out.println();
			b[j-1] = (ArrayList<Integer>)a.clone();
			a.removeAll(a);
		} // 입력 for 종료
			//////////
		
		// 출력시작
//날짜 출력 시작
		System.out.println("############ 인생역전 Lottoria ############");
	
		// 현재 날짜/시간
		LocalDateTime now = LocalDateTime.now();
		
		
		int dw = now.getDayOfWeek().getValue(); // 요일(숫자) ex) 월 = 1, 화 =2....
		
		String work = (dw == 1) ? "월": (dw == 2) ? "화" : (dw == 3) ? "수" : (dw == 4) ? "목" : (dw == 5) ? "금" : (dw == 6) ? "토" : "일";
		// work = 요일 한글로 저장

		// System.out.println(now);
		// - 2021-06-17T06:43:21.419878100

		// 포맷팅
		String formatedNow1 = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd일"));
		String formatedNow2 = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		// 포맷팅 현재 날짜/시간 출력
		
		//발행일 연/월/일 (요일) 시:분:초 출력
		System.out.print("발행일	 " + formatedNow1);
		System.out.print(" (" + work + ") ");
		System.out.println(formatedNow2);
		
		
		//변수 HH에 시간을 정수로 저장
		int HH = Integer.parseInt(now.format(DateTimeFormatter.ofPattern("HH")));
		// 변수 k = if문 결과에따라 플러스 일수 값 저장해주기 (토요일 만들기)
		int k = 0;
		//요일이 일요일 일때 (월~토) k에 6일 저장
		if(dw == 7) {
			k = 6;
		}
		//요일이 토요일 AND 시간이 21시 넘어가면 k에 7일 저장 다음주로 추첨일 지정
		else if(dw == 6 && HH >= 21 ) {
			k = 7;
		}
		//토요일인 6이하면 6 - 현재일수(숫자로) 해서 일수값을 K에 저장
		else {
			k = 6 - dw;
		}
		// 현재 시간 플러스데이이용해서 토요일 만들어주기 
		LocalDateTime Enday = now.plusDays(k);
		//추첨일 3에 저장
		String formatedNow3 = Enday.format(DateTimeFormatter.ofPattern("yyyy/MM/dd일"));
		
		
		System.out.print("추첨일	 " + formatedNow3);
		//고정값 출력
		System.out.print(" (토) ");
		System.out.println("21:00:00");
		
		//지급기한은 추첨일 기준 연+1,일+1 값을 Dday 저장
		LocalDateTime Dday = Enday.plusYears(1).plusDays(1);
		dw = Dday.getDayOfWeek().getValue();
		String formatedNow4 = Dday.format(DateTimeFormatter.ofPattern("yyyy/MM/dd일"));
		work = (dw == 1) ? "월": (dw == 2) ? "화" : (dw == 3) ? "수" : (dw == 4) ? "목" : (dw == 5) ? "금" : (dw == 6) ? "토" : "일";
		
		//지급기한 출력
		System.out.print("지급기한	 " + formatedNow4);
		System.out.println(" (" + work + ") ");
		
//날짜 출력 끝
		
//입력한 로또번호 및 로또가격 출력
		int num = 65; //A에 해당하는 아스키코드값 및 시작 A~ 
		System.out.println("-----------------------------------------");
		for (int i = 0; i < n; i++) {
			char ch = (char)num;
			System.out.print(ch + " ");
			if(aute[i] == 1) {
				System.out.print("자 동 ");
			}
			else if(aute[i] == 2) {
				System.out.print("수 동 ");
			}
			
			for (int l = 0; l < 6; l++) {
				if(b[i].get(l) < 10) {
					System.out.print("0"+b[i].get(l) + "   ");					
				}
				else {
					System.out.print(b[i].get(l) + "   ");					
				}
			}
			num++;
			System.out.println();
		}
		System.out.println("-----------------------------------------");
		System.out.println("                                   $" + ((j-1)*1000));
//로또 번호 및 가격 출력 끝
		
// 당첨번호/보너스번호 출력
		//처음 자동출력이랑 동일 하지만 6개가아닌 보너스 번호포함 7개 랜덤값 저장
		int[] c = new int[7];
		for (int i = 0; i < 7; i++) {
			while (true) {
				c[i] =  ((int)(Math.random() * 45) + 1);
				r = c[i];
				count = 0;

				for (int ii = 0; ii < 7; ii++) {
					if (r == c[ii]) {
						count++;
					}
				}
				// 배열에 저장한 랜덤값이 모든자리 값이랑 비교할때 같은자리에 값을 한번은 지나가니
				// 두번 카운팅되면 해당값 지우고 다시 랜덤값 받아옴
				if (count == 2) {
					c[i] = 0;
				} else {
					break;
				}
			}
		}
		//당첨번호 출력
		System.out.print("당첨 번호 : ");
		for (int i = 0; i < c.length-1; i++) {
			System.out.print(c[i] + " ");
		}
		System.out.println();
		
		//보너스 번호출력 (보너스 번호값 고정위치)
		System.out.print("보너스 번호 : " + c[6]);
		System.out.println();
// 당첨번호/보너스번호 출력끝
		
// 당청결과 출력
		System.out.println("#################### 당첨 결과 ####################");
		
		//저장된 번호출력 및 당첨 or 낙첨 추가
		num = 65;
		for (int i = 0; i < n; i++) {
			count = 0;
			char ch = (char)num;
			System.out.print(ch + " ");
			if(aute[i] == 1) {
				System.out.print("자 동 ");
			}
			else if(aute[i] == 2) {
				System.out.print("수 동 ");
			}
			
			for (int l = 0; l < 6; l++) {
				if(b[i].get(l) < 10) {
					System.out.print("0"+b[i].get(l) + "   ");					
				}
				else {
					System.out.print(b[i].get(l) + "   ");					
				}
			}
			num++;
			
			for(int nak = 0; nak < 6; nak++ ) {
				for(int dang = 0; dang < 6; dang++) {
					if(c[nak] == b[i].get(dang)) {
						count++;
					}
				}
			}
			
			if(count >= 3) {
				System.out.print("(당첨)");
			}
			else {
				System.out.print("(낙첨)");
			}
			
			System.out.println();
		}
		
		
		System.out.println("################################################");
// 당첨결과 출력 끝
	}
}
