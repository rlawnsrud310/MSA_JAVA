
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, "utf-8"));

			Scanner sc = new Scanner(System.in);
			
			double a = sc.nextDouble();
			double b = sc.nextDouble();
			
			double p = (a-100)*0.9;
			double pp = (b-p)*(100/p);
			
			if(pp <= 10) {
				bw.write("정상");bw.flush();
			}
			else if(pp > 10 && pp <= 20) {
				bw.write("과체중");bw.flush();				
			}
			else {
				bw.write("비만");bw.flush();				
				
			}
			
	}
}