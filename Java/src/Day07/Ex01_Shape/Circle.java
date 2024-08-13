package Day07.Ex01_Shape;

public class Circle extends Shape{
	double raidus;
	public Circle() {
		this(0.0);
	}
	public Circle(double raidus) {
		this.raidus = raidus;
	}
	
	@Override
	double area() {
		
		return Math.PI * Math.pow(raidus, 2);
	}
	@Override
	double round() {
		
		return  Math.PI * raidus;
	}
	
	@Override
	public String toString() {
		return "Circle [raidus=" + raidus + "]";
	}
	
	public double getRaidus() {
		return raidus;
	}
	public void setRaidus(double raidus) {
		this.raidus = raidus;
	}
}
