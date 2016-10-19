package ru.skorikov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/** Тест класса SearchSubString

@author Alexey Skorikov
@since 17.10.2016
@verion 1.0

*/

public class SearchSubStringTest{
	
	@Test
	public void whenSearchSubStringTrue(){
		
		String origiinString = "Origin String";
		String subString = "gin";
		SearchSubString string = new SearchSubString();
		boolean result = string.searchSubString(origiinString, subString);
		assertTrue(result);
		
	}
}