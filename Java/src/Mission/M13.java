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
		int count, r;
		for (int j = 1; j <= n; j++) {
			System.out.print("[" + j + " 게임] (1.자동 / 2.수동)");
			int n1 = sc.nextInt();
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
			a.removeAll(a);
		} // 입력 for 종료
			//////////
			// 출력시작
		System.out.println("############ 인생역전 Lottoria ############");
		// 날짜 참고
		// https://hianna.tistory.com/607
		// https://winkitee.tistory.com/113

		// 현재 날짜/시간
		LocalDateTime now = LocalDateTime.now();

		int dw = now.getDayOfWeek().getValue(); // 요일(숫자)
		String work = (dw == 1) ? "월"
				: (dw == 2) ? "화" : (dw == 3) ? "수" : (dw == 4) ? "목" : (dw == 5) ? "금" : (dw == 6) ? "토" : "일";
		// 현재 날짜/시간 출력

		// System.out.println(now);
		// 2021-06-17T06:43:21.419878100

		// 포맷팅
		String formatedNow1 = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd일"));
		String formatedNow2 = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		// 포맷팅 현재 날짜/시간 출력

		System.out.print("발행일	 " + formatedNow1);
		System.out.print(" (" + work + ") "); // 요일 : THURSDAY(4)
		System.out.println(formatedNow2);
		int counting = dw;
		int k = 0;
		while (true) {
			if (counting == 6) {
				break;
			} else {
				k++;
				counting++;
			}
		}
		String dk = now.format(DateTimeFormatter.ofPattern("dd"));
		int dM = Integer.parseInt(dk) + k;
		String formatedNow3 = now.format(DateTimeFormatter.ofPattern("yyyy/MM/" + dM + "일"));

		System.out.print("추첨일	 " + formatedNow3);
		System.out.print(" (토) ");
		System.out.println("21:00:00");

		String dk1 = now.format(DateTimeFormatter.ofPattern("yyyy"));
		String dk2 = now.format(DateTimeFormatter.ofPattern("dd"));

		int dM1 = Integer.parseInt(dk1) + 1;
		int dM2 = Integer.parseInt(dk2) + 1;
		String formatedNow4 = now.format(DateTimeFormatter.ofPattern(dk1+(("/mm/")+k)+dk2 + "일"));
		work = (dw == 1) ? "월": (dw == 2) ? "화" : (dw == 3) ? "수" : (dw == 4) ? "목" : (dw == 5) ? "금" : (dw == 6) ? "토" : "일";
		System.out.print("지급기한	 " + formatedNow4);
		System.out.print(" (" + work + ") ");

	}
}
