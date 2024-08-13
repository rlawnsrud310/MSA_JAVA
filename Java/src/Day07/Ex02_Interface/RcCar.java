package Day07.Ex02_Interface;

public class RcCar implements RemoteControl{

	int speed;

	@Override
	public void turnON() {
		System.out.println("RC카 전원을 킵니다.");
		
	}

	@Override
	public void turnOFF() {
		System.out.println("RC카 전원을 끕니다.");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSpeed(int speed) {
		//최대 속력을 초과하지 못하게 지정
		if( speed > RemoteControl.MAX_SPEED) {
			this.speed = RemoteControl.MAX_SPEED;
			
		}
		// 최저 속력 미만이 되지 않도록 지정
		else if ( speed < RemoteControl.MIN_SPEED) {
			this.speed = RemoteControl.MIN_SPEED;
			System.out.println("최저 속력!");
		}
		else{
			this.speed = speed;
		}
		System.out.println("현재 속도 : " + this.speed);
		
	}

}
