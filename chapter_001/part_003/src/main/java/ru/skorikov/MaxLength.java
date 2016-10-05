package skorikov;
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
	@param три числа типа double - длины сторон треугольника
	@return maxlength - наибольшая сторона
	*/
	
	public double max (double AB, double AC, double BC){
		double maxlength;
		
		if ((AB > BC) && (AB > AC)){
			maxlength = AB;
		}else{
		if (AC > BC){
			maxlength = AC;
		}else{
			if(AC < BC){
				maxlength = BC;
			}else{
			System.out.println("Треугольник не существует.");
			maxlength = 0;
		}
	}
}
		return maxlength;
}
}