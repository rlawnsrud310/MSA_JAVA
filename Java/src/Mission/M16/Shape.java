package Mission.M16;

public abstract class Shape{
	Point point = new Point();
	
	public abstract double area();
	public abstract double round();
	
	public Point getPoint() {
		return point;
	}
	public Point setPoint(int i, int j) {
		point.x = i;
		point.y = j;
		return point;
	}


	
	
	
	
}
