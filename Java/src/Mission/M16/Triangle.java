package Mission.M16;

public class Triangle extends Shape{
	int w;
	int h;
	@Override
	public double area() {
		w = point.x;
		h = point.y;
		double area = (w * h)/2;
		return area;
	}

	@Override
	public double round() {
		w = point.x;
		h = point.y;
		double round = w * 3;
		return round;
	}
	
	public Triangle() {
		this(0,0);
	}

	public Triangle(int w, int h) {
		this.w = w;
		this.h = h;
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
		return "Triangle [w=" + w + ", h=" + h + "]";
	}
	
	
}
