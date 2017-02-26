package ru.skorikov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**3.1.
 Тест для класса Triangle
  
 @author Alexey Skorikov
 @since 18.09.2016
 @verion 1.0
 */
 public class TriangleTest{
	 
	 @Test
	 public void whenTriangleTrue(){
		 Point a = new Point(0,10);
		 Point b = new Point(10,0);
		 Point c = new Point(0,0);
		 Triangle triangle = new Triangle(a,b,c);
		 double area = triangle.area();
		 assertThat(area, is(50d));
		 
	 }
	 
	 @Test
	 public void whenTriangleFalse(){
		 Point a = new Point(0,1);
		 Point b = new Point(0,2);
		 Point c = new Point(0,3);
		 Triangle triangle = new Triangle(a,b,c);
		 double area = triangle.area();
		 assertThat(area, is(0d));
	 }
		
 }