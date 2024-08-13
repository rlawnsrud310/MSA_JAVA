package Day07.Ex01_Shape;

public class Point {
	//맴버 변수
	int x,y;
	
	// alt + shift + s -> Generate Contructor Using Field...
	// 기본생성자
	public Point() {
		
	}

	// 매개변수가 있는 생성자
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	// alt + shift + s -> Generate toString()...
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
}



