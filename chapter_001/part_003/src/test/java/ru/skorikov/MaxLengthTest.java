package skorikov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/** Тест класса MaxLength

@author Alexey Skorikov
@since 01.10.2016
@verion 1.0

*/

public class MaxLengthTest{
	@Test
	public void whenMaxLengthTest(){
		MaxLength maximum = new MaxLength();
		double result = maximum.max(1, 2, 3);
		assertThat(result, is(3.0));
	} 
}