package ru.skorikov;
import static java.lang.Math.*;

/**
4.1. Создать программу вычисляющую формулу квадратного уравнения
Создать класс Square в нем один методы float calculate(int x) и 
void show(start, finish, step). Метод должен вычислять значение функции 
y = a*x2 + b * x + c; параметры a b c задаются через конструктор. 
void show(start, finish, step) - вывести на экран значение функции в диапазоне 
от x1 до x2 c шагом step. 

2. Обязательно нужно добавить тесты проверяющие методы.
@author Alexey Skorikov
@since 05.10.2016
@verion 1.0
*/

public class Square{
	
	/** 
	Поля класса
	*/
	
	public int a;
	public int b;
	public int c;
	
	/** 
	Конструктор класса
	*/
	
	public Square(int a, int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	/**
	Вычисляем функцию
	@param x
	@return значение функции
	*/
	public float calculate(int x){
		return (float)(this.a * Math.pow(x, 2) + this.b * x + this.c);
	}
	/**
	Выводим на экран значение функции в диапазоне 
	от x1 до x2 c шагом step. 
	@param start, finish,step
	@return значение функции в диапазоне
	*/
	public void show (int start, int finish, int step){
		for(int i = start;i <= finish; i += step){
			System.out.print(calculate(i) + " ");
		}
	}
}