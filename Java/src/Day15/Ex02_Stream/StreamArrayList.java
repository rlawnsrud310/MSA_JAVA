package Day15.Ex02_Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Person {
	String name;
	int age;
	public Person() {
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}

public class StreamArrayList {

	public static void main(String[] args) {
		List<Person> personList = new ArrayList<Person>();
		personList.add( new Person("김조은", 20));
		personList.add( new Person("이조은", 30));
		personList.add( new Person("박조은", 25));
		personList.add( new Person("최조은", 35));
		personList.add( new Person("조은", 28));
		personList.add( new Person("김조", 22));
		
		// map - 메핑
		// : 스트림 요소를 사용하려는 형태로 변환하는 연산
		// * 이름(name)만 추출(매핑)하여 반복
		personList.stream().map( (person) -> {return person.getName();})
							.forEach( name -> System.out.println(name) );
		System.out.println();
		personList.stream().map( (p) -> {return p.getAge();})
		.forEach(age -> System.out.println(age));
		
		System.out.println();
		// stream().filter = 필터링(조건문,if) 
		// 이름 3글자인 사람들
		personList.stream().filter( (per) -> per.getName().length() >= 3)
			.forEach( name -> System.out.println(name) );
		
		System.out.println();
		// * 나이 순 - 내림차순 (+오름 -내림)
		personList.stream()
				.sorted( Comparator.comparing( p -> -p.getAge() ))
				.forEach( p -> System.out.println(p));
		System.out.println();
		
		// * 나이 순 - 오름차순( 마이너스기호 적용불가)
		// 메소드 레퍼런스 (::)
		// * 클래스명::메소드명
		// : 메소드 레퍼런스(참조정보)를 지정하는 문법
		// - 메소드 호출 시, 전달인자로 메소드 레퍼런스를 지정하여 넘겨줄 수 있다,
		// - 메소드를 통해 메소드를 전달하는 람다식을 대체하는 문법이다.
		// - 람다식을 간결하게 표현하기 위한 방법
		// (person) -> { return person.getName(); }
		// person -> person.getNmae()
		// Person::getNmae
		personList.stream()
		.sorted( Comparator.comparing( Person::getAge) )
		.forEach( p -> System.out.println(p));
		System.out.println();
		
		// 나이순 내림차순(reversed)
		personList.stream()
		.sorted( Comparator.comparing( Person::getAge).reversed() )
		.forEach( p -> System.out.println(p));
		System.out.println();
		
		// 이름이 3글자인 사람수
		long count = personList.stream().
		filter( (per) -> per.getName().length() >= 3)
		.count();
		System.out.println(count);
		System.out.println();
		// sum() = 스트림요소의 합계
		
		int sume =	personList.stream().
				filter( (per) -> per.getName().length() == 2)
				.mapToInt(per -> per.getAge())
				.sum();
				System.out.println(sume);
		
	}
		
}
