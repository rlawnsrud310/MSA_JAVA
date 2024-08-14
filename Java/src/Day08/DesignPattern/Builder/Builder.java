package Day08.DesignPattern.Builder;

public class Builder {
	public static void main(String[] args) {
		Pikachu pikachu = new Pikachu.Builder()
				.energy(100).type("전기").level(10).build();
		
		System.out.println(pikachu);
	}
}

