package ru.skorikov;
/**
2.3. 
Нужно сделать файл Calculator.java и создать в нем класс Calculator. 
в классе должно быть внутреннее поле double result. 
и четыре метода add(double first, double second) по аналогии 
substruct div multiple. Методы должны быть void. 
Каждый метод вычисляет арифметическую операцию и записывает 
ее в поле result

* @author Alexey Skorikov
* @since 18.09.2016
* @verion 1.0
*/

public class Calculator{
	public double result;
	public void add (double first, double second){
		/**
		Складываем два числа(first и  double)
		записываем в result.
		*/
		this.result = first + second;
	}
	public void substruct (double first, double second){
		/**
		Отнимаем second от first
		Записываем в result.
		*/
		this.result = first -second;
	}
	public void div (double first, double second){
		/**
		Делим first на  second
		Записываем в result.
		*/
		this.result = first / second;
	}
	public void multiple (double first, double second){
		/**
		Умножаем first на second
		Записываем в result.
		*/
		this.result = first * second;
	}
}
