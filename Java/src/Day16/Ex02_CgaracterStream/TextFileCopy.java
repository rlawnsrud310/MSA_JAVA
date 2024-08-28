package Day16.Ex02_CgaracterStream;

import java.io.FileReader;
import java.io.FileWriter;

public class TextFileCopy {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		
		int data = 0;
		
		try {
			// 경로는 프로젝트 기본 경로로 잡는다.
			// 프로젝트 경로			- C:/~/~/Java
			// ./					- 현재 폴더(디렉토리)
			// ./src/Day16/test.txt	- C:/~/~/Java/src/Day16/test.txt
			fr = new FileReader("./src/Day16/test.txt");	// 파일 입력 문자스트림
			fw = new FileWriter("./src/Day15/Test2.txt");	// 파일 출력 문자스트림
			
			//파일 입력
			while( (data = fr.read()) != -1 ) {
				// 파일 출력
				fw.write(data);
			}
			fr.close();
			fw.close();
			System.out.println("파일이 복사되었습니다.");
			System.out.println("Test.txt -> Test2.txt");
			
			
		} catch (Exception e) {
			System.out.println("입출력 시, 에러가 빌생하였습니다.");
			e.printStackTrace();
		}
	}
}
