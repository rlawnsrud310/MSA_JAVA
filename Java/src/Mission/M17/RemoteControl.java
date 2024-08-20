package Mission.M17;

public interface RemoteControl {
	int MAX_Speed = 200;
	int MIN_Speed = 0;

	
	abstract public void on();
	abstract public void off();
	abstract public void setSpeed(int speed);
	abstract public void changeBattery();
}
