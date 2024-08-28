package D10_13.Ex05_Compare.Comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 1. Comparator 인터페이스를 구현
 * 2. Compare() 메소드를 오버라이딩
 * 		- 정렬 기준1 : 나이순 오름차순
 * 		- 정렬 기준2 : 이름순 내림차순
 */

class User implements Comparator<User>{
	
	String id;
	String name;
	int age;

	
	public User() {
	this("-", "-", 0);
	}

	public User(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compare(User o1, User o2) {
		// 정렬 기준1 : 나이순 - 오름차순
		// 정렬기준 2 : 이름순 - 내림차순
		
		// o1 : 해당 객체
		// o2 : 비교 객체
		
		// 1. 각각 객체의 나이를 가져와서 age1,age2 로 선언
		// 1. 각각 객체의 이름를 가져와서 name1,name2 로 선언
		
		// 정렬 로직 작성
		// o1 이 더 큰 객체 -> 양수
		// o1 과 o2 같은 객체 -> 0
		// o1 이 더 작은 객체 -> 음수
		
		int age1 = o1.getAge();
		int age2 = o1.getAge();
		String name1 = o1.getName();
		String name2 = o2.getName();
		
//		// 방법 1
//		// 정렬 기준1 - 나이 오름차순
//		if( age1 > age2) return 1;
//		if( age1 < age2) return -1;
//		if( age1 == age2) {
//			// 정렬 기준2 - 이름 내림차순
//			int gap = name1.compareTo(name2);
//			if(gap > 0) return -1;
//			if(gap < 0) return 1;
//			if(gap == 0) return 0;
//			return -gap;
//		}
		
		// 방법 2
		int result = age1 - age2;
		int result2 = name1.compareTo(name2);
		//if(result == 0) return -result2;
		return result == 0 ? result2 : result;

	}
}	

public class ComparatorEx {
	public static void main(String[] args) {
		List<User> UserList = Arrays.asList(
				new User("Joeun1004", "홍조은", 34),
				new User("Joeun1004", "전조은", 25),
				new User("Joeun1004", "김조은", 25),
				new User("Joeun1004", "배조은", 25),
				new User("Joeun1004", "황조은", 25),
				new User("Joeun1004", "박조은", 28),
				new User("Joeun1004", "권조은", 30),
				new User("Joeun1004", "이조은", 22)
				);				
		
		System.out.println("* 정렬 전");
		for (User user : UserList) {
			System.out.println(user);
		}
		System.out.println("----------------------------------");
		
		// 정렬
		// * Book 클래스에서 구현한 compareTo() 메소드의 비교기준에 따라서 정렬
		Collections.sort(UserList, new User());
		
		// 정렬후
		System.out.println(" * 정렬 후");
		for (User user : UserList) {
			System.out.println(user);
		}
		System.out.println("----------------------------------");
		
		
		List<User> UserList2 = Arrays.asList(
				new User("joeun1004", "홍조은", 34),
				new User("moeun1004", "전조은", 25),
				new User("aoeun1004", "김조은", 25),
				new User("coeun1004", "배조은", 25),
				new User("toeun1004", "황조은", 25),
				new User("soeun1004", "박조은", 28),
				new User("doeun1004", "권조은", 30),
				new User("boeun1004", "이조은", 22)
				);
		
		Collections.sort(UserList2, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				// 아이디를 기준으로 오름차순
				String id1 = o1.getId();
				String id2 = o2.getId();
				int result = id1.compareTo(id2);
				return result;
			}
			
		});
		
		System.out.println("아이디순 오름차순");
		for (User user : UserList2) {
			System.out.println(user);
		}
		
		
	}
	
}
