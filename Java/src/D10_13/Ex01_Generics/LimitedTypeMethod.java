package D10_13.Ex01_Generics;

public class LimitedTypeMethod {

	// 제네릭 메소드 타입 제한
	// Number : 자식 클래스 (Integer, Double 등 숫자관련 클래스)
	public <T extends Number> void method(T t) {
		System.out.println( t.intValue());
		System.out.println( t.doubleValue());
	}
	
	public static void main(String[] args) {
		LimitedTypeMethod ltm = new LimitedTypeMethod();
		ltm.<Integer>method(1234);
		ltm.<Double>method(12.34);
	}
}
