import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		
		LocalDateTime now = LocalDateTime.of(2000, 1, 1, a, b, 0);
		
		now = now.minusMinutes(30);
		
		
		String ff = now.format(DateTimeFormatter.ofPattern("H m"));
		
		System.out.println(ff);
		
		
		
		
		
	}
}