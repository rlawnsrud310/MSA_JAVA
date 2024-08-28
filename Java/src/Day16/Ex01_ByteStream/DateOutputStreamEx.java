package Day16.Ex01_ByteStream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DateOutputStreamEx {
	public static void main(String[] args) {
		
		// 파일 경로
		String filePath = "sample.dat";
		
		// FileOutputStream 객체를 이용하여, Byte 단위로 데이터 출력
		try (
			FileOutputStream fos = new FileOutputStream(filePath);
			
			// BufferedOutputStream 
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			// DateOutputStream 객체로 기본 데이터 타입을 출력
			DataOutputStream dos = new DataOutputStream(bos);
		) {	
			dos.writeInt(1000);
			dos.writeDouble(3.14);
			dos.writeBoolean(true);
			System.out.println("sample.dat 파일을 출력하였습니다.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}