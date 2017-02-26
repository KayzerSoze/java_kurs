package ru.skorikov; 
import static java.lang.Math.*;

/** 3.1. Создать класс Point c двумя полями x, y. 
Этот класс будет описывать точку в системе координат. 

@author Alexey Skorikov
@since 25.09.2016
@verion 1.0

*/

//Класс с двумя полями
public class Point {
	public double x;
	public double y;

//Конструктор класса
public Point(double x, double y) {
	this.x = x;
	this.y = y;
}

//Метод класса вычисляющий расстояние между точками
public double distanceTo(Point point) {
	return Math.sqrt(Math.pow(point.y - this.y,2)+ Math.pow(point.x - this.x,2));
}
}