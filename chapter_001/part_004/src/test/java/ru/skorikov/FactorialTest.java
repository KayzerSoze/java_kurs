package ru.skorikov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/** Тест класса Factorial

@author Alexey Skorikov
@since 10.10.2016
@verion 1.0

*/
	public class FactorialTest{
		
		@Test
		public void whenFactorialIsTrue(){
			
			Factorial fac = new Factorial();
			int result = fac.compute(5);
			assertThat(result, is(120));
			
	}
	}