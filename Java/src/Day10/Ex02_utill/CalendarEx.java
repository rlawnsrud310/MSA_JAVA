package Day10.Ex02_utill;

import java.util.Calendar;

public class CalendarEx {
	public static void main(String[] args) {
		// * new Calendar() 대신, getInstance() 메소드로 객체를 사용한다.
		Calendar now = Calendar.getInstance();
		printCalendar("현재", now);
	
		// 자바 프로그래밍 마지막 수업일
		Calendar test = Calendar.getInstance();
		test.set(2024, Calendar.SEPTEMBER,4);
		printCalendar("자바 마지막 수업일(연/월/일)", test);
		
		// 종강일
		Calendar lastDay = Calendar.getInstance();
		lastDay.set(2025, Calendar.FEBRUARY,10,18,20,0);
		
		// 오늘로부터 종강일 까지 D-Day
		long lastT = lastDay.getTimeInMillis();
		long nowT = now.getTimeInMillis();
		System.out.println("lastT - notT = " + (lastT - nowT));
		
		long dDay = (lastT - nowT) / (1000 * 60 * 60 *24);
		System.out.println("D-day : " + dDay + "일");
		
		Calendar met = Calendar.getInstance();
		met.set(2000,3,10);
		long me = met.getTimeInMillis();
		
		long ddDay = (nowT - me) / (1000 * 60 * 60 *24);
		System.out.println("생후 : " + ddDay + "일");
	
	}
	
		
	// 날짜/시간 정보(Calendar)를 출력하는 메소드
	private static void printCalendar(String msg, Calendar cal) {
		int year = cal.get( Calendar.YEAR);				// 월(0~11)
		int month = cal.get( Calendar.MONTH)+1;			
		int day = cal.get( Calendar.DAY_OF_MONTH);		// 일~토(1~7)
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);	// 12시 표시
		int hour = cal.get(Calendar.HOUR);				// 24시 표시
		int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		int millisecond = cal.get(Calendar.MILLISECOND);
	
		System.out.println(msg + " : ");
		System.out.println(year + "/" + month + "/" + day + "/");
		
		// 일요일(1)~토요일(7)
		String Day = "";
		switch (dayOfWeek) {
		
			case Calendar.SUNDAY:	Day = "일요일"; break;
			case Calendar.MONDAY:	Day = "월요일"; break;
			case Calendar.TUESDAY:	Day = "화요일"; break;
			case Calendar.WEDNESDAY:	Day = "수요일"; break;
			case Calendar.THURSDAY:	Day = "목요일"; break;
			case Calendar.FRIDAY:	Day = "금요일"; break;
			case Calendar.SATURDAY:	Day = "토요일"; break;

			default:
			break;
		}
		int ampm = Calendar.AM_PM;
		System.out.print(Day);
		
		System.out.print("(" + hourOfDay + "시)");
		if( ampm == Calendar.AM) System.out.println("오전");
		if( ampm == Calendar.PM) System.out.println("오후");
		
		System.out.println(hour + "시 " + minute + "분 " + second + "초 " + millisecond +"밀리초 " );
	}
}
