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
@since 31.10.2016
@version 1.0

*/

public class Tracker{
	private Tipe[] tipes = new Tipe[10];
	private int position = 0;
	private static final Random RN = new Random();
	
	String generateId(){
		return String.valueOf(System.currentTimeMillis()+RN.nextInt());
	}
	public Tipe add(Tipe tipe){
		tipe.setId(this.generateId());
		this.tipes[position++] = tipe;
		return tipe;
	}
	public void editing(Tipe tipe){
		for(int i=0; i <this.position; i++){
			if(tipes[i] != null && tipes[i].getId().equals(tipe.getId() )){
				tipes[i].setName(tipe.getName());
				tipes[i].setDescription(tipe.getDescription());
				tipes[i].setDate(tipe.getDate());
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
	public Tipe[] findByName(String name){
		int index= 0;

		for (int i = 0; i < this.position;i++){
			if(tipes[i] != null && tipes[i].getName().equals(name)){
				index++;
			}
		}
		Tipe[] result = new Tipe[index];
		int k = 0;
		for (int j = 0; j < tipes.length; j++){
				if (tipes[j] != null && tipes[j].getName().equals(name)){
				result[k] = tipes[j];
					k++;
				}

		}
		return result;
	}
	public Tipe[] findByDescription(String description){
        int index= 0;

        for (int i = 0; i < this.position;i++){
            if(tipes[i] != null && tipes[i].getDescription().equals(description)){
                index++;
            }
        }
        Tipe[] result = new Tipe[index];
        int k = 0;
        for (int j = 0; j < tipes.length; j++){
            if (tipes[j] != null && tipes[j].getDescription().equals(description)){
                result[k] = tipes[j];
                k++;
            }

        }
        return result;
	}
	
}