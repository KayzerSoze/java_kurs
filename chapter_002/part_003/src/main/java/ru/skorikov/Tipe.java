package ru.skorikov;

import static java.lang.Math.*;
import java.util.*;
	
/**
Класс заявка
	
@author Alexey Skorikov
@since 10.11.2016
@version 2.0

*/
public class Tipe{
	
	private String id;
	private String name;
	private long date;
	private String description;
	private String comment;
	
	public Tipe(){
	}
	public Tipe(String name, String description){
		this.name = name;
		this.description = description;
	}

	
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return id;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setDate(long date){
		this.date = date;
	}
	public long getDate(){
		return date;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription(){
		return description;
	}
	public void setComment(String comment){
		this.comment = comment;
	}
	public String getComment(){
		return comment;
	}
}