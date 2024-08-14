package lombok.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

//@ 이노테이션
//@NoArgsConstructor	: 기본 생성자
//@AllArgsCoonstructor	: 모든 매개변수 생성자
//@Getter				: getter
//@setter				: setter
//@toString			: toString

//@Date				: @Getter, @Setter, @ToString
//						  @RequiredArgsConstrutor
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class preson {
	private String name;
	private int age;
	private double height;
	private double weight;
	

}
