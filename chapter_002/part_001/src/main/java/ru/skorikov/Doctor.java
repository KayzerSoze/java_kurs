package ru.skorikov;
/**
 * Created with IntelliJ IDEA.
 * User: user18
 * Date: 07.04.17
 * Time: 13:04
 * To change this template use File | Settings | File Templates.
 */
public class Doctor extends  Profession {
    public Doctor(String name, String diplom, int age, int worked_time) {
        super(name, diplom, age, worked_time);
    }
    @Override
    public void work(Profession profession){
        System.out.println(super.getName() + " лечит "+ profession.getName() );
    }
}
