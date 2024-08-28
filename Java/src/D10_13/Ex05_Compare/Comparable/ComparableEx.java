package D10_13.Ex05_Compare.Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 책(Book) 을 가격순으로
 */
class Book implements Comparable<Book>{

	String title;
	String author;
	int price;
	

	public Book() {
	}

	public Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * compareTo()
	 * 해당 객체 this와 비교 객체 o의 크기 기준을 설정하여 반환메소드
	 *	return
	 *			양수(1)	: 해당객체 > 비교객체
	 *			0		: 해당객체 = 비교객체
	 *			음수(-1)	: 해당객체 < 비교객체
	 */
	@Override
	public int compareTo(Book o) {
		
		// * 가격순으로 오름차순
		int thisPrice = this.getPrice();
		int comPrice = o.getPrice();
		
		// 방법 1
//		if(thisPrice > comPrice) {
//			return 1;
//		}
//		else if(thisPrice < comPrice) {
//			return -1;
//		}
//		else {
//			return 0;
//		}
		
		// 방성2
//		if( thisPrice > comPrice) return 1;
//		if( thisPrice == comPrice) return 0;
//		if( thisPrice < comPrice) return -1;
		
		// 방법3
//		return thisPrice - comPrice;
		
		// 방법 4
		int asc = thisPrice - comPrice;		// 오름차순
		int desc = comPrice - thisPrice;	// 내림차순
		
		return asc;
		
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price=" + price + "]";
	}
}

public class ComparableEx {
	
		public static void main(String[] args) {
			List<Book> bookList = new ArrayList<Book>();
			bookList.add(new Book("책1", "저자1", 50000));
			bookList.add(new Book("책2", "저자2", 40000));
			bookList.add(new Book("책3", "저자3", 30000));
			bookList.add(new Book("책4", "저자4", 20000));
			bookList.add(new Book("책5", "저자5", 10000));
			
			System.out.println("* 정렬 전");
			for (Book book : bookList) {
				System.out.println(book);
			}
			System.out.println("----------------------------------");
			
			// 정렬
			// * Book 클래스에서 구현한 compareTo() 메소드의 비교기준에 따라서 정렬
			Collections.sort(bookList);
			
			// 정렬후
			System.out.println(" * 정렬 후");
			for (Book book : bookList) {
				System.out.println(book);
			}
			System.out.println("----------------------------------");
			
			
			
		}
}
