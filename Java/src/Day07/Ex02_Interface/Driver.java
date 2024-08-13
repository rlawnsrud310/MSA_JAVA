package Day07.Ex02_Interface;

public class Driver {
	public static void main(String[] args) {
		// 인터페이스를 구현한 클래스 객체를 만드는 법
		// - 인터페이슽타입 객체명 = new 구현클래스();
		
		
		// RC카
		RemoteControl carRc = new RcCar();
		carRc.turnON();
		
		carRc.parking(false);
		carRc.setSpeed(20);
		carRc.parking(true);
		carRc.turnOFF();
		System.out.println();
		
		RemoteControl.changeBatter();
		System.out.println();
		
		//드론
		RemoteControl dronRc = new Drone();
		dronRc.turnON();
		dronRc.parking(false);
		dronRc.setSpeed(15);
		dronRc.parking(true);
		dronRc.turnOFF();
		System.out.println();
	}
}
