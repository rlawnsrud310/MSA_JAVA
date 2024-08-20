package Mission.M16;

public class Circle extends Shape{
	int r;
	@Override
	public double area() {
		r = point.x;
		double area = r * r *3.14;
		return area;
	}

	@Override
	public double round() {
		r = point.x;
		double round = r * 2 * 3.14;
		return round;
	}
	public Circle() {
		this(0);
	}

	private Circle(int r) {
		this.r = r;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	@Override
	public String toString() {
		return "Circle [r=" + r + "]";
	}
	
	

}
