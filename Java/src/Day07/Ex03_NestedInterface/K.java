package Day07.Ex03_NestedInterface;

public class K implements I.J{

	@Override
	public void methodA() {
		System.out.println("중첩 인터페이스 - MethodA()");
		
	}

	@Override
	public void methodB() {
		System.out.println("중첩 인터페이스 - MethodB()");
		
	}

}
