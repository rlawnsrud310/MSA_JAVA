package lombok.basic;
import lombok.Data;
import lombok.Builder;

@Data
@Builder

public class Pikachu {
	int energy;
	String type;
	int level;
}
