package ru.skorikov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/** Тест класса Square

@author Alexey Skorikov
@since 05.10.2016
@verion 1.0

*/
	
public class SquareTest{
	@Test
	public void calculateTest(){
		Square square = new Square(1,2,3);
		float result = square.calculate(1);
		assertThat(result, is(6.0f));
	}
	
}