package ru.skorikov;

import static java.lang.Math.*;
import java.util.*;
	
/**
Реализовать класс Tracker. Данный класс используется как 
хранилище для заявок. В нем должны быть методы: добавление, 
редактирования, удаления, получения списка всех заявок 
и списка по фильтру.

На каждый метод должен быть написан тест.

Здесь не должно быть системы ввода вывода - ни каких System.in
	
@author Alexey Skorikov
@since 10.11.2016
@version 2.0

*/

public class Tracker{
	private Tipe[] tipes = new Tipe[10];
	private int position = 0;
	private static final Random RN = new Random();
	
	String generateId(){
		return String.valueOf(System.currentTimeMillis()+RN.nextInt());
	}
	public Tipe add(Tipe tipe){
		tipe.setDate(System.currentTimeMillis());
		tipe.setId(this.generateId());
		this.tipes[position++] = tipe;
		return tipe;
	}
	public void editing(String Id, Tipe tipe){
		for(int i=0; i <this.position; i++){
			if(tipes[i] != null && tipes[i].getId().equals(Id)){
				tipes[i].setName(tipe.getName());
				tipes[i].setDescription(tipe.getDescription());
			}
		}
	}
	public void delete(Tipe tipe){
			for(int i = 0; i != this.position; i++){
				if(tipes[i].equals(tipe)){
					tipes[i] = null;
				}
			}
			for(int j = 0; j!=this.position; j++){
				if(tipes[j] == null){
					for(int k = j; k != this.position; k++){
						tipes[k+1] = tipes[k];
					}
				}
			}
			tipes[this.position] = null;
		}
		
	public void addComment(Tipe tipe, String comment){
		if(tipe != null){
				tipe.setComment(comment);
		}
	}
	public Tipe[] findByAll(){
		Tipe[] result = new Tipe[this.position];
		for (int index=0; index!=this.position;index++){
			result[index] = tipes[index];
		}
		return result;
	}		
	public Tipe findById(String id){
		Tipe result = null;
		for (Tipe tipe : tipes){
			if (tipe !=null && tipe.getId().equals(id)){
				result = tipe;
				break;
			}
		}
		return result;
	}
	public Tipe findByName(String name){
		Tipe result = null;
		for (Tipe tipe : tipes){
			if (tipe != null && tipe.getName().contains(name)) {
				result = tipe;
				break;
			}
		}
		return result;
	}
	public Tipe findByDescription(String description){
        Tipe result = null;
        for (int i = 0; i < this.position;i++){
            if(tipes[i] != null && tipes[i].getDescription().equals(description)){
                result = tipes[i];
				break;
            }
        }
        return result;
	}
	
}