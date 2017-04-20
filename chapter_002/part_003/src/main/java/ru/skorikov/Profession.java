package ru.skorikov;

import javax.xml.bind.SchemaOutputResolver;

/**
 * Created with IntelliJ IDEA.
 * Autor: Alex Skorikov
 * Date: 07.04.17
 * Version Stady_2
 *
 */
public class Profession {
    private String Name;//Имя
    private String Diplom;//Наличие диплома
    private int age;//Возраст
    private int worked_time;//Стаж


    public Profession(String name, String diplom, int age, int worked_time) {
        Name = name;
        Diplom = diplom;
        this.age = age;
        this.worked_time = worked_time;
    }

    public Profession(String name) {
        Name = name;
    }

    public String work(Profession profession){
        return Name + profession.getName();
    }

    String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDiplom() {
        return Diplom;
    }

    public void setDiplom(String diplom) {
        Diplom = diplom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWorked_time() {
        return worked_time;
    }

    public void setWorked_time(int worked_time) {
        this.worked_time = worked_time;
    }

}
