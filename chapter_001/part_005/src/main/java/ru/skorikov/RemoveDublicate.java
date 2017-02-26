package ru.skorikov;
import static java.lang.Math.*;

/**
Дано. Массив строк. String[] - нужно убрать дубликаты. 

@author Alexey Skorikov
@since 13.10.2016
@version 1.0
*/
public class RemoveDublicate{
		
	public String[] removeDublicate(String[] array){
		//Меняем дубликаты на "null"
		for(int i = 0; i < array.length-1; i++){
            for(int j = array.length-1;j >i;j--){
                if(array[i] == array[j]){
                    array[j] = "null";
                }
            }
        }
		//Определяем размер нового массива
		int k = 0;
        for(int p = 0; p < array.length;p++){
            if(array[p]!="null"){
                k++;
            }
        }
		//Заполняем новый отсортированный массив
		String[] returnArray = new String[k];
        int y = 0;
        for(int n = 0; n < array.length;n++){
                if (array[n] != "null") {
                    returnArray[y] = array[n];
                    y++;
                }

        }
		return returnArray;
	}
}