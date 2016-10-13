package ru.skorikov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/** Тест класса ArraySort

@author Alexey Skorikov
@since 12.10.2016
@verion 1.0

*/

public class ArraySortTest{
			
	@Test
	public void whenArraySorted(){
		int[] values = new int[]{1, 3, 4, 5, 2};
		int[] result = new int[]{1, 2, 3, 4, 5};
		ArraySort array = new ArraySort();
		values = array.arraysort(values);
		assertThat(result,is(values));
		
	}
}
	
