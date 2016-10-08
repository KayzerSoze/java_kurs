package ru.skorikov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/** Тест класса Point

@author Alexey Skorikov
@since 25.09.2016
@verion 1.0

*/

public class PointTest{
	@Test
	public void whenDistanceTwoPointsTest(){
		Point first = new Point(0,0);
		Point second = new Point(2,0);
		double distance = first.distanceTo(second);
		assertThat (distance, is(2d));
	} 
}