package Day08.Anonymous;

import lombok.basic.preson;

public class AnonymousPersonTest {
	public static void main(String[] args) {
		AnonymousPreson ap = new AnonymousPreson();
		ap.method();
		
		Person person = new Person() {
			String name = "최민식";
			int age = 50;
			@Override
			void work() {
				System.out.println(name + "(" + age + ")");
				System.out.println("연기를 합니다");
			}		
		};
		person.work();
		
	}
}
