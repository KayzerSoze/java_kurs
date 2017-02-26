package ru.skorikov;
import static java.lang.Math.*;

/**
Дано. Двухмерный квадратный массив int values[][] - нужно написать метод, 
который будет поворачивать данный массив на 90 градусов. 

@author Alexey Skorikov
@since 13.10.2016
@verion 1.0
*/

public class ArrayRotate{
	
		
	/** Метод поворачивает массив на 90 градусов
	@param int[][] values
	@return int[][] result
	*/
	
	public int[][] rotate(int[][] values){
		//получаем количество строк и столбцов исходного массива
		int a = values.length;
		int b = values[0].length;
		//новый массив с количесвом строк равным количеству столбцов исходного
		//и количеством столбцов равным количеству строк.
		int [][] result = new int[b][a];
		//заполняем новый массив		
		for(int i = 0; i < a; i++) {
			for(int j = 0; j < b; j++) {
				
				result[b - 1 - j][i] = values[i][j];
				
			}
		}
		return result;
	}
}