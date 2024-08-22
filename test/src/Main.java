import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[3];
		a[0] = sc.nextInt();
		a[1] = sc.nextInt();
		a[2] = sc.nextInt();

		
		for (int i = 0; i < 3; i++) {
			if(a[i] % 2 == 0)
			System.out.println(a[i]);
		}
		sc.close();
	}		
}

