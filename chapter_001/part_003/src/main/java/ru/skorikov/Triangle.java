package ru.skorikov; 
import static java.lang.Math.*;

/**Дано. три точки. 
Нужно составить программу которая будет вычислять площадь треугольника 
образованного этими точками. 
Программа должна учитывать условия невозможности построить треугольник 
через эти точки.

@author Alexey Skorikov
@since 18.09.2016
@verion 1.0
 */


//Класс треугольник
public class Triangle {
	public Point a;
	public Point b;
	public Point c;

//Конструктор класса использующий класс Point
public Triangle(Point a, Point b, Point c) {
	this.a = a;
	this.b = b;
	this.c = c;
}

//Метод вычисляющий площадь 
public double area() {
	double AB = this.a.distanceTo(b);
	double AC = this.a.distanceTo(c);
	double BC = this.b.distanceTo(c);
	double pperimeter = (AB + AC + BC)/2;
	double square = Math.sqrt((pperimeter-AB)*(pperimeter-AC)*(pperimeter-BC)*pperimeter);
	if (square == 0){System.out.println("Невозможно построить треугольник.");}     
	return square;
}
}

