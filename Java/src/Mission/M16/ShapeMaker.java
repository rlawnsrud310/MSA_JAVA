package Mission.M16;

import java.util.Scanner;

public class ShapeMaker {
	public static void main(String[] args) {
		Shape triangle = new Triangle();//삼각형
		Shape rectangle = new Rectangle();//사각형
		Shape circle  = new Circle(); //원
		int a = 0;

		Scanner sc = new Scanner(System.in);
		while(true){
			int x,y;

			System.out.println("1. 삼각형");
			System.out.println("2. 사각형");
			System.out.println("3. 원형");
			System.out.print("번호입력 : ");
			String num = sc.next();

			switch (num) {
				case "그만" :	a = 1;break;
				case "1":
						System.out.print("밑변 : ");
						x = sc.nextInt();
						System.out.println("높이 : ");
						y = sc.nextInt();
						triangle.setPoint(x,y);
						break;
				case "2":
						System.out.print("가로 : ");
						x = sc.nextInt();
						System.out.println("세로 : ");
						y = sc.nextInt();
						rectangle.setPoint(x,y);
						break;
				case "3":
						System.out.print("반지름: ");
						x = sc.nextInt();
						circle.setPoint(x, 0);
						break;
	
				default:break;
				}
			if(a == 1) {break;}
		}

		
		System.out.println("삼각형 둘레 : "+triangle.round());
		System.out.println("삼각형 넓이 : "+triangle.area());

		System.out.println("사각형 둘레 : "+rectangle.round());
		System.out.println("사각형 넓이 : "+rectangle.area());

		System.out.println("원 둘레 : "+circle.round());
		System.out.println("원 넓이 : "+circle.area());
		
		
		double allrount = triangle.round()+rectangle.round()+circle.round();
		double allarea = triangle.area()+rectangle.area()+circle.area();
		
		System.out.println("둘레 총합 : "+allrount);
		System.out.println("넓이 총합 : "+allarea);
		
		
		
	}
}
