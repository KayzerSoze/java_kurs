package ru.skorikov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/** Тест класса RemoveDublicate

@author Alexey Skorikov
@since 12.10.2016
@version 1.0

*/
public class RemoveDublicateTest{
	
	@Test
	public void whenRemoveDublicateTest(){
		
		String[] origiinArray = {"a", "b", "c", "c", "d", "a", "a"};
		String[] sortedArray = {"a", "b", "c", "d"};
		
		RemoveDublicate array = new RemoveDublicate();
		String[] result = array.removeDublicate(origiinArray);
		assertThat(result, is(sortedArray));
	}
}