package Day16.Ex04_Serilization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializePeerson {

	public static void main(String[] args) {
		// Person.dat 파일을 역질렬화하여 객체로 입력
		try (
				FileInputStream fis = new FileInputStream("./src/Day16/Person.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				){
			Person person = (Person) ois.readObject();
			System.out.println(person);
			System.out.println("Person.dat 파일 데이터를 역직렬화하여 Person 객체로 가져옴");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
