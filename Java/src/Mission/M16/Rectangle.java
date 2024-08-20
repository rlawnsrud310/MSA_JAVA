package Mission.M16;

public class Rectangle extends Shape{
	
	int w;
	int h;

	@Override
	public double area() {
		this.w = point.x;
		this.h = point.y;
		double area = w*h;
		return area;
	}

	@Override
	public double round() {
		this.w = point.x;
		this.h = point.y;
		double round = (w*2) + (h*2);
		return round;
	}
	
	public Rectangle() {
		this(0,0);
	}


	public Rectangle(int i, int j) {
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	@Override
	public String toString() {
		return "Rectangle [w=" + w + ", h=" + h + "]";
	}
	
	

}
