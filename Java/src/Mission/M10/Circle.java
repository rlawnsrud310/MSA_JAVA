package Mission.M10;

public class Circle {
	double radius;
	
	public Circle() {
		this(0.0);
	}

	
	public Circle(double radius) {
		this.radius = radius;
	}



	double getArea() {
		double area = radius * radius * Math.PI;
		area = Math.round(area * 1000000000*100)/100000000000.0;
		return area;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
}
