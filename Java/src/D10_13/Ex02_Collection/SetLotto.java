package D10_13.Ex02_Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class SetLotto {
	public static void main(String[] args) {
		Set<Integer> lottoSet = new HashSet<Integer>();
		Random random = new Random();
		
		// 1~45 랜덤 수, 6개를 lottoSet 컬렉션에 중복 없이 저장
		while( lottoSet.size() < 6) {
			int num = random.nextInt(45)+1;
			boolean check = lottoSet.add(num);
			if( !check) {
				System.out.println(num + "(이/가) 중복되어 뽑혀 다시 뽑습니다.");
			}
		}
		System.out.println("로또 번호 : " + lottoSet);
		
		List<Integer> lottoList = new ArrayList<Integer>(lottoSet);
		
		Collections.sort(lottoList);
		System.out.println("로또 번호 : " + lottoList);
	}
}
