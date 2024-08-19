package Mission.M14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class M14 {
	public static void main(String[] args) throws IOException {
		ArrayList<String>[] _Str1 = new ArrayList[100];
		ArrayList<Integer> _Str2 = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new FileReader("src/Mission/M14/student.txt"));
		String str;
		int i = 0;
		
		/*
		System.out.print(arr[0]); //번호
		System.out.print(arr[1]); //이름
		System.out.print(arr[2]); //성적
		System.out.print(arr[3]); //반
		System.out.println();*/
		
		//배열선언
		for (int j = 0; j < _Str1.length; j++) {
			_Str1[j]  = new ArrayList<String>();
		}
		//_Str1 = 한줄 나눠 입력 (split 사용)
		while ((str = br.readLine()) != null) {
			String[] arr = str.split("/");
			
			for (int j = 0; j < arr.length; j++) {
				_Str1[i].add(arr[j]);
			}
			int a = Integer.parseInt(arr[2]);
			_Str2.add(a);
			i++;
		}
		//최대값과 _Str2 값을 저장할 su 변수생성
		int max,su=0;
		System.out.println("번호	이름	성적	반");
		for (int j = 0; j < i; j++) {
			
			max = 0;
			//최대값 max 변수에 저장
			for (int j2 = 0; j2 < i; j2++) {
				su = _Str2.get(j2);
				if(max < su) {
					max = su;
				}
			}
			//최대값이 포함된 배열번호로 _Str1 배열변수값 출력
			for (int k = 0; k < 4; k++) {
				System.out.print(_Str1[(_Str2.indexOf(max))].get(k) + "	");
			}
			System.out.println();
			
			//max 중복 출력되지않게 해당 배열에 0 저장
			_Str2.set(_Str2.indexOf(max), 0);
			
			
		}

	}
}
