package Mission.M17;

public class RcCar implements RemoteControl{
	double battery;
	double speed;
	@Override
	public void on() {
		System.out.println("전원 on");
		
	}

	@Override
	public void off() {
		System.out.println("전원 off");
	}

	@Override
	public void setSpeed(int speed) {
		
		
	}

	@Override
	public void changeBattery() {
		System.out.println("전원 교체");
		
	}

}
