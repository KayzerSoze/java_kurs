package skorikov;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**2.3.Создать программу Калькулятор
 * Тест для класса Calculator
 * 
 * @author Alexey Skorikov
 * @since 18.09.2016
 * @verion 1.0
 */
 
 public class CalculatorTest{
	 @org.testing.annotation.Test
	 public void whenAddTwoNumbers(){
		 Calculator calculator = new Calculator();
		 calculator.add(1,3);
		 double result = calculator.result;
		 assertThat(result, is(4d));
	 }
	 @org.testing.annotationTest
	 public void whenSubstructTwoNumbers(){
		 Calculator calculator = new Calculator();
		 calculator.substruct(5,2);
		 double result = calculator.result;
		 assertThat(result,is(3d));
	 }
	 @org.testing.annotationTest
	 public void whenDivTwoNumbers(){
		 Calculator calculator = new Calculator();
		 calculator.div(4,2);
		 double result = calculator.result;
		 assertThat(result, is(2d));
	 }
	 @org.testing.annotationTest
	 public void whenMultipleTwoNumbers(){
		 Calculator calculator = new Calculator();
		 calculator.multiple(2,2);
		 double result = calculator.result;
		 assertThat(result, is(4d));
	 }
 }
