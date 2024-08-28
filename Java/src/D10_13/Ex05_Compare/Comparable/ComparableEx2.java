package D10_13.Ex05_Compare.Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 1. Movie 영화 클래스 정의
 * 2. Movie 변수는 title, author, price 로 변수 선언
 * 3. 영화를 제목순으로 오름차순 정렬
 * 		- String 의 compareTo() 활용
 */

class Movie implements Comparable<Movie>{

	String title;
	String autgor;
	int price;
	public Movie() {
	}
	public Movie(String title, String autgor, int price) {
		this.title = title;
		this.autgor = autgor;
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public String getAutgor() {
		return autgor;
	}
	public int getPrice() {
		return price;
	}
	@Override
	public String toString() {
		return "Movie [title=" + title + ", autgor=" + autgor + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Movie o) {
		String thisTitle = this.getTitle();
		String comTitle = o.getTitle();

		int result = thisTitle.compareTo(comTitle);
		
		return result;		//	-result	내림차순
	}
	
	
}


public class ComparableEx2 {

		public static void main(String[] args) {
			List<Movie> MovieList = new ArrayList<Movie>();
			MovieList.add(new Movie("나영화", "저자1", 50000));
			MovieList.add(new Movie("가영화", "저자2", 40000));
			MovieList.add(new Movie("아영화", "저자3", 30000));
			MovieList.add(new Movie("차영화", "저자4", 20000));
			MovieList.add(new Movie("다영화", "저자5", 10000));
			
			System.out.println("* 정렬 전");
			for (Movie movie : MovieList) {
				System.out.println(movie);
			}
			System.out.println("----------------------------------");
			
			// 정렬
			// * Book 클래스에서 구현한 compareTo() 메소드의 비교기준에 따라서 정렬
			Collections.sort(MovieList);
			
			// 정렬후
			System.out.println(" * 정렬 후");
			for (Movie movie : MovieList) {
				System.out.println(movie);
			}
			System.out.println("----------------------------------");
		}
	
}
