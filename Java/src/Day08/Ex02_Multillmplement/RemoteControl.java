package Day08.Ex02_Multillmplement;

public interface RemoteControl {
	int MAX_SPEED = 300;
	int MIN_SPEED = 0;
	
	int MAX_Volume = 300;
	int MIN_Volume= 0;
	
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	void setChannel(int channel);
	void setSpeed(int  speed);
	
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("음소거 설정되었습니다.");
			setVolume(MIN_SPEED);
		}
		else {
			System.out.println("음소거 해제되었습니다");
			setVolume(10);
		}
	}
	
	default void parking(boolean check) {
		if(check) {
			System.out.println("주차");
			setSpeed(MIN_SPEED);
		}
		else {
			System.out.println("주행");
			setSpeed(MAX_SPEED);
		}
	}
	
	static void changeBatter() {
		System.out.println("배터리 교체");
	}
}
