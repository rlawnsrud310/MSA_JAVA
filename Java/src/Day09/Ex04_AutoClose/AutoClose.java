package Day09.Ex04_AutoClose;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class AutoClose {
	public static void main(String[] args) {

		// try(자동으로 지원해제할 객체 생성) { }
		// : finally 구문에서 close() 하지 안호아도, 자동으로 자원해제해준다
		// * AutoCloable 인터페이스를 구현한 클래스이어야 자동으로 자원해제 가능

		try (FileInputStream fis = new FileInputStream("src/Day09/Ex04_AutoClose/test.txt");
				InputStreamReader in = new InputStreamReader(fis, "UTF-8");) {
			int read = 0;

			while ((read = in.read()) != -1) {
				System.out.print((char) read);
			}
		} catch (FileNotFoundException e) {
			// FileNotFoundException : 파일이 존재하지 않았을 때 발생하는 예외
			e.printStackTrace();
			System.err.println("파일을 찾을수없습니다.");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			System.err.println("지원하지 않는 인코딩입니다.");
		} catch (IOException e) {
			// IOException : 입력 및 출력 과정에서 발생하는 예외
			e.printStackTrace();
			System.err.println("");

		} //finally {
//			if (fis != null) {
//				try {
//					fis.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			if(in != null) {
//				in.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}

		
	}
}
