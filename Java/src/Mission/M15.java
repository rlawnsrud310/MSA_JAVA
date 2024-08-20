package Mission;

class Book{
	String isbn,title,writer, content;
	int price;
	
	public Book() {
		this("일련번호","제목","지은이","장르",0);
	}

	

	public Book(String isbn, String title, String writer, String content, int price) {
		this.isbn = isbn;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return isbn + "|" + title + "	|" + writer + "	|"+content + "		|"+ price ;
	}
	
}
class Library extends Book{
	Book library1 = new Book("123123","이게자바냐", "김자바", "자바 김자바", 33000);
	Book library2 = new Book("112112","정보처리기사","김휴먼", "국가기술자격",45000);
	Book library3 = new Book("001001","실무 DB", "박다비", "디비디비딥	", 60000);
	
}


public class M15 {
	public static void main(String[] args) {
		Library library = new Library();
		
		System.out.println("====================ALOHA 스터디 도서관====================");
		System.out.println(library.library1);
		System.out.println(library.library2);
		System.out.println(library.library3);
	}
	
}
