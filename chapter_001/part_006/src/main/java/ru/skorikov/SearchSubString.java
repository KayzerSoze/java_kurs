package ru.skorikov;
import static java.lang.Math.*;

/**
Создать программу проверяющую, что строка sub является подстрокой origin.
boolean contains(String origin, String sub).
Нельзя использовать String.indexOf String.contains. 
Нужно преобразовать строку в массив символов и проверить. 

@author Alexey Skorikov
@since 17.10.2016
@verion 1.0

*/
public class SearchSubString{
	
	public boolean searchSubString(String origin, String sub){
		
		boolean isSearchTrue = false;
		char[] originChar = origin.toCharArray();
		char[] subChar 	= sub.toCharArray();
		int sum = 0;
		
		for(int i = 0; i <= originChar.length - subChar.length; i++){
			for(int j = 0; j < subChar.length; j++){
				if(subChar[j] == originChar[j+i]){
					sum++;
				}else{
					sum = 0;
				}
			}
			if(sum == subChar.length){
				isSearchTrue = true;
			}	
		}
		return isSearchTrue;
	}
}
