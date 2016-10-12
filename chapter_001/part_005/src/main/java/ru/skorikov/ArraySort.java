package ru.skorikov;
import static java.lang.Math.*;

/**
Дано. Массив int values[]. Нужно написать метод который будет сортировать 
данный массив использую алгоритм пузырька.  

@author Alexey Skorikov
@since 12.10.2016
@verion 1.0
*/

public class ArraySort{
	
	public int[] arraysort (int[] values){
		
		int temp = values[0];
		for(int i = values.length-1; i >=0; i--){
			for(int j = 0; j < i; j++){
				if (values[j] > values[j+1]){
				temp = values[j];
				values[j] = values[j+1];
				values[j+1] = temp;
			}
			}
		}
		return values;
	}
}