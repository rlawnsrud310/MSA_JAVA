package Day07.Ex02_Interface;

public class Drone implements RemoteControl{
	int speed;
	
	@Override
	public void turnON() {
		System.out.println("드론 전원 ON");
		
	}

	@Override
	public void turnOFF() {
		System.out.println("드론 전원 OFF");
		
	}

	@Override
	public void setSpeed(int speed) {
		if( speed >MAX_SPEED) {
			this.speed = MAX_SPEED;
			System.out.println("최대 속력!");
		}
		else if( speed < MIN_SPEED) {
			this.speed = MIN_SPEED;
			System.out.println("최저 속력!");
		}
		else {
			this.speed = speed;
		}
		System.out.println("현재 속도 : " + this.speed);
		
	}
	
}