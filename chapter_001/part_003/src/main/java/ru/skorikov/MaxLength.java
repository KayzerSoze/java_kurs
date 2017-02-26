package ru.skorikov;
import static java.lang.Math.*;

/** Создать класс с методом max - определяющий максимальную 
длинну стороны треугольника построенного из задание 1.

@author Alexey Skorikov
@since 01.10.2016
@verion 1.0

*/
/** Класс для определения наибольшей стороны треугольника
*/

public class MaxLength {
	
	/** Метод max 
	@param 	неопределенное количество чисел типа double
	@return maxlength -наибольшее число
	*/
	
	public double max (double... nums){
		double maxlength = 0;
		for(double i:nums){
			if(i > maxlength){
				maxlength = i;
			}
		}
		return maxlength;
}
}