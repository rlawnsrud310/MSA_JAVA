package Mission.M10;

public class Triangle {
	double width,height;
	public Triangle() {
		this(0.0,0.0);
	}
	
	public Triangle(double width, double heoght) {
		this.width = width;
		this.height = heoght;
	}

	@Override
	public String toString() {
		return "Triangle [width=" + width + ", height=" + height + "]";
	}

	double getArea() {
		double area = (width * height) / 2;
		return area;
	}

	

	
}
