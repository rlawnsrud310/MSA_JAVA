package Mission.M17;

public class Drone implements RemoteControl{

	double battery = (double)(Math.random()*50);
	double speed;
	@Override
	public void on() {
		System.out.println("Drone 전원 on");
		
	}

	@Override
	public void off() {
		System.out.println("Drone 전원 off");
	}

	@Override
	public void setSpeed(int speed) {
		if(speed > MAX_Speed) {
			System.out.println("최고속도는 200입니다.");
			this.speed = MAX_Speed;
			
		}
		else if(speed < MIN_Speed){
			System.out.println("최소속도는 0입니다.");
			this.speed = MIN_Speed;
		}
		else {
			this.speed = speed;
		}
		System.out.println("Drone현제 속도 : "+this.speed);	
		
	}

	@Override
	public void changeBattery() {
		System.out.println("Drone 현재 배터리 : " + (int)battery + "%");
		System.out.println("전원 교체");
		battery = 100;
		System.out.println("Drone 현재 배터리 : " + (int)battery + "%");	
	}

}
