package Day09.Ex04_AutoClose;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class FileInputText {
	public static void main(String[] args) {
		FileInputStream fis = null;
		InputStreamReader in = null; // *

		try {
			fis = new FileInputStream("src/Day09/Ex04_AutoClose/test.txt");
			in = new InputStreamReader(fis, "UTF-8"); // *
			int read = 0;

			while ((read = in.read()) != -1) {
				System.out.print((char) read);
			}
		} catch (FileNotFoundException e) {
			// FileNotFoundException : 파일이 존재하지 않았을 때 발생하는 예외
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			System.err.println("지원하지 않는 인코딩입니다.");
		} catch (IOException e) {
			// IOException : 입력 및 출력 과정에서 발생하는 예외
			e.printStackTrace();

		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
