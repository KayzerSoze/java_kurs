package ru.skorikov;
/**
 * Created with IntelliJ IDEA.
 * Autor: Alex Skorikov
 * Date: 07.04.17
 * Version Stady_2
 *
 */
public class Doctor extends  Profession {

    public String worked_process = " лечит ";
    public String training;//Повышение квалификации

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public Doctor(String name) {
        super(name);
    }

    @Override
    public String work(Profession profession) {
        String work = super.getName() + worked_process + profession.getName();
        return work;
    }

}
