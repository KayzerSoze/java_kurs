package ru.skorikov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/** Тест класса ArrayRotate

@author Alexey Skorikov
@since 12.10.2016
@verion 1.0

*/

public class ArrayRotateTest{
	
	@Test
		public void whenArrayRotateTrue(){
	
		int[][] values = new int[][]   {{1, 2, 3, 4},
										{1, 2, 3, 4},
										{1, 2, 3, 4}
										};
										
		int[][] result = new int[][]	{{4, 4, 4},
										{3, 3, 3},
										{2, 2, 2},
										{1, 1, 1}};
										
		ArrayRotate array = new ArrayRotate();
		values = array.rotate(values);
		assertThat(values, is(result));
		}
	
}
	
