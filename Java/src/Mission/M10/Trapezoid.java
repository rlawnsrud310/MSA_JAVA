package Mission.M10;

public class Trapezoid {
	double top,bottom,height;
	
	public Trapezoid() {
		this(0.0,0.0,0.0);
	}

	public Trapezoid(double top, double bottom, double height) {
		this.top = top;
		this.bottom = bottom;
		this.height = height;
	}
	
	double getArea() {
		double area = (top + bottom) * height / 2;
		return area;
	}

	@Override
	public String toString() {
		return "Trapezoid [top=" + top + ", bottom=" + bottom + ", height=" + height + "]";
	}
	
}
