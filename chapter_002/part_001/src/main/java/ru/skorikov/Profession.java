package ru.skorikov;

import javax.xml.bind.SchemaOutputResolver;

/**
 * Created with IntelliJ IDEA.
 * User: user18
 * Date: 07.04.17
 * Time: 13:03
 * To change this template use File | Settings | File Templates.
 */
public class Profession {
    protected String Name;
    protected String Diplom;
    protected int age;
    protected int worked_time;
    protected String worked_process;


    public Profession(String name, String diplom, int age, int worked_time) {
        Name = name;
        Diplom = diplom;
        this.age = age;
        //this.worked_time = worked_time;
    }

    public Profession(String name) {
        Name = name;
    }

    public String work(Profession profession){
        String work = Name + profession.getName();
        return work;
    }

    public String getName() {
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
/**
    public String getWorked_process() {
        return worked_process;
    }

    public void setWorked_process(String worked_process) {
        this.worked_process = worked_process;
    }*/
}
