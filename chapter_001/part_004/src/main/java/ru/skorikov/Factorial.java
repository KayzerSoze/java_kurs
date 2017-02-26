package ru.skorikov;


/** Написать программу для вычисления факториала. Использовать циклы. 

@author Alexey Skorikov
@since 10.10.2016
@verion 1.0
*/

public class Factorial{
	
	public int compute(int entr){
		int result = 1;
		for (int i = 1; i <= entr; i++){
			result = result * i;
		}
		return result;
	}
}