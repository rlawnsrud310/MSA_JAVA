package Day10.Ex02_utill;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarLotto {
	/**
	 * 	이번 주 로또 추첨 일시를 구해보자.
	 * (조건)
	 * - 매일 6시~24까지 판매
	 * - 추첨일(토요일)에는 오후 8시 판매 마감
	 * - 추첨일(토요일) 오후 8시부터 다음일(일요일) 오전6시까지 판매 정지
	 * 
	 * Q. 오늘 날짜/시간을 기준으로 로또를 구매한다면, 추첨일시는 언제인가?
	 * (출력)
	 * 추첨일 : 2024/08/24 21:00:00
	 */
	
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		//일변경
		int a = 7 - cal.get(Calendar.DAY_OF_WEEK);
		cal.add(cal.DAY_OF_WEEK, a);
		int b = cal.get(Calendar.HOUR);
		int c = cal.get(Calendar.AM_PM);
		if((c==0)&&(b>=6) ||(c==1)) {
			if(a == 0 && b>=8) {
				System.out.println("로또 구매불가");				
			}
			else {
				System.out.println("로또 구매가능");
			}
		}
		else {
			System.out.println("로또 구매불가");							
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String today = sdf.format(cal.getTime());
		System.out.println("추첨일 : " + today + " 21:00:00");
	}
}
