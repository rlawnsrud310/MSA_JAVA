package Mission.M10;

public class Ractangle {
	double width,hieght;

	public Ractangle() {
		this(0.0,0.0);
	}
	
	public Ractangle(double width, double hieght) {
		this.width = width;
		this.hieght = hieght;
	}

	double getArea() {
		double area = width * hieght;
		return area;
	}

	@Override
	public String toString() {
		return "Ractangle [width=" + width + ", hieght=" + hieght + "]";
	}
}
