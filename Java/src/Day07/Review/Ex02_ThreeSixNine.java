package Day07.Review;

public class Ex02_ThreeSixNine {
	public static void main(String[] args) {
		//num = 1~100
	    int num = 1;
	    //s = 3이포함되는지 비교해주는 변수
	    int s;
	    //count1,2 2자리수 숫자중 하나라도 3이 있으면 num출력x
	    int count1, count2;
	    
	    for (int i = 1; i <= 100; i++) {
	    	//한바퀴돌때마다 0으로 초기화
	    	count1 = 0; count2 = 0;
	    	//number = 정수를 문자로 전환
	    	String number = String.valueOf(num);
	    	//split사용해서 문자를 나눠 n배열에 저장
		    String[] n = number.split("");
		    
		    for (int j = 0; j < n.length; j++) {
		    	//s = Integer.parseInt이용해서 문자를 다시 정수로 전환
				s = Integer.parseInt(n[j]);
				//or사용해서 3,6,9 가 포함되면 *출력
				//count1,2, 로 369 모두가 포함됬는지안됬는지 구분(열쇠기능)
				if(s == 3 || s == 6 || s == 9) {
					System.out.print("*");
					count1 = 1;
				}
				else {
					count2 = 1;
				}
			}
		    //count 변수가 0 1(AND) 하면 num 출력
		    if(count1 == 0 && count2 == 1) {
		    	System.out.print(num);
		    }
		    //num = 1~100
		    num++;
		    System.out.println();
			
		}
	    
	    
	}
}
