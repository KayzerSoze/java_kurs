package ru.skorikov;
/**
 * Created with IntelliJ IDEA.
 * User: user18
 * Date: 07.04.17
 * Time: 13:04
 * To change this template use File | Settings | File Templates.
 */
public class Teacher extends Profession {

    public String worked_process = " учит ";

    public Teacher(String name) {
        super(name);
    }

    @Override
    public String work(Profession profession) {
        String work = super.getName() + worked_process + profession.getName();
        return work;
    }


}
