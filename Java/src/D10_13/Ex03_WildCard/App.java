package D10_13.Ex03_WildCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.basic.preson;

public class App {
	static Scanner sc = new Scanner(System.in);
	static List<Course<?>> CourseList = new ArrayList<Course<?>>();
	static List<Person> studentList = new ArrayList<Person>();
	
	public static void main(String[] args) {
		int no = 0;
		do {
			menu();					//메뉴 출력
			no = sc.nextInt();		// 메뉴 번호 입력
			sc.nextLine();			// 엔터 제거
			System.out.println();	// 한줄 개행
			
			
			switch (no) {
			// 과정 등록
			case 1: CourseList.add( createCourse());break;
			// 수강생 등록
			case 2 : addStudent();break;
			// 과정 확인
			case 3 : printCourseList();break;
			// 수강생 확인
			case 4 : printStudent();break;
			default: System.out.println("유요한 메뉴 번호를 입력해주세요.");	break;
			}
		} while (no != 0);
	}
	
	/**
	 * 메뉴 출력
	 */
	
	public static void menu() {
		System.out.println("::::: 수강생 등록 프로그램 :::::");
		System.out.println("1. 과정 등록");
		System.out.println("2. 수강생 등록");
		System.out.println("3. 과정 확인");
		System.out.println("4. 수강생 확인");
		System.out.println("5. 종료하기");
		System.out.println("::::::::::::::::::::::::::");
	}
	
	/**
	 * 과정등록
	 * @return
	 */
	
	public static Course<?> createCourse(){
		System.out.println("- 과정 종류 (일반인, 직장인, 학생) : ");
		String type = sc.nextLine();
		System.out.println("- 과정 명 : ");
		String name = sc.nextLine();
		
		Course<?> course = switch (type) {
			case "일반인" ->{
				Course<Person> newCouse = new Course<Person>();
				yield newCouse.createCourse(name, newCouse);
			}
			case "직장인" ->{
				Course<Worker> newCouse = new Course<Worker>();
				yield newCouse.createWorkerCourse(name, newCouse);
			}
			case "학생" ->{
				Course<Student> newCouse = new Course<Student>();
				yield newCouse.createStudentCourse(name, newCouse);
			}
	
			default -> throw new IllegalArgumentException("유효하지 않은 과정 종류 : " + type);
		};
		return course;
	}
		
		public static void printCourseList() {
			System.out.println(":::::::::: 과정 목록 ::::::::::");
			for (Course<?> Course : CourseList) {
				System.out.println(Course);
			}
			System.out.println("::::::::::::::::::::::::::::");
		}
		public static void addStudent() {
			System.out.print("- 수강생 종류 (일반인, 직장인, 학생, 고등학생, 중학생) : ");
			String type = sc.nextLine();
			System.out.println("- 수강생 이름 : ");
			String name = sc.nextLine();
			System.out.println("- 등록할 과정 명");
			String courseName = sc.nextLine();
		
			Course<?> selectedCourse = new Course();
			
			// 해당 수강생을 등록할 과정을 지정
			for (int i = 0; i < CourseList.size(); i++) {
				Course<?> course = CourseList.get(i);
				// 입력한 과정명과 등록된 과정명이 일치하면
				if( course.getName().equals(courseName)) {
					selectedCourse = course;		//지정된 과정
					break;
				}
			}
		
		
			// 선택된 과정에서 수강생 목록을 가져온다.
			List<Person> students = (List<Person>) selectedCourse.getStudents();
			// 수강생 목록에 지금 입력한 수강생을 추가한다.
			// * 수강생 종류에 맞게 객체를 생성하여 추가한다.
			Person student = switch (type) {
			case "일반인" -> new Person(name);
			case "직장인" -> new Worker(name);
			case "학생" -> new Student(name);
			case "고등학생" -> new HighStudent(name);
			case "중학생" -> new MiddleStudent(name);
			default -> throw new IllegalArgumentException("유효하지 않은 수강생 종류 입니다 : "  + type);
			};
			
			students.add(student);		// 해당 과정에 수강생 추가
			studentList.add(student);	// 원생 목록에 수강생 추가
		}
		
		
		/**
		 * 수강생 확인
		 */
		public static void printStudent() {
			System.out.print("- 수강생 이름 : ");
			String name = sc.nextLine();
			
			boolean check = false;
			for (int i = 0; i < studentList.size(); i++) {
				Person person = studentList.get(i);
				if( person.getName().equals(name)) {
					System.out.println("* 등록된 수강생입니다 : " + name);
					check = true;
					break;
				}
			}
			// check : false 그대로 남아있는 경우 - 등록 X
			if( !check) {
				System.out.println("* 등록되지 않은 이름입니다.");
				return;
			}
			// 등록된 수강생인 경우 수강 중인 과정을 출력
			for (int i = 0; i < CourseList.size(); i++) {
				// 해당 과정의 수강생 목록
				List<Person> students = (List<Person>) CourseList.get(i).getStudents();
				// 해당 과정의 과정명
				String courseName = CourseList.get(i).getName();
				
				System.out.println(":::::::::: 수강 중인 과정 ::::::::::");
				// 해당 과정의 수강생 목록을 확인하여, 입력한 이름과 일치하는 경우가 있으면
				// 해당 수강생이 수강하는 과정으로, 출력한다.
				for (int j = 0; j < students.size(); j++) {
					if( students.get(j).equals(name)) {
						System.out.println("- " + courseName);
					}
				}
			}
			System.out.println("::::::::::::::::::::::::::::::");
		}



}
