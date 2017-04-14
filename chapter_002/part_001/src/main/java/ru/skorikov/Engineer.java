package ru.skorikov;
/**
 * Created with IntelliJ IDEA.
 * Autor: Alex Skorikov
 * Date: 07.04.17
 * Version Stady_2
 *
 */
public class Engineer extends Profession {

    public String worked_process = " изобретает для ";

    public Engineer(String name) {
        super(name);
    }

    @Override
    public String work(Profession profession) {
        String work = super.getName() + worked_process + profession.getName();
        return work;
    }

}
