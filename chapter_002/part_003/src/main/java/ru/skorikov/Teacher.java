package ru.skorikov;
/**
 * Created with IntelliJ IDEA.
 * Autor: Alex Skorikov
 * Date: 07.04.17
 * Version Stady_2
 *
 */
public class Teacher extends Profession {

    public String worked_process = " учит ";
    public String academic_degree;//Ученая степень

    public String getAcademic_degree() {
        return academic_degree;
    }

    public void setAcademic_degree(String academic_degree) {
        this.academic_degree = academic_degree;
    }

    public Teacher(String name) {
        super(name);
    }

    @Override
    public String work(Profession profession) {
        String work = super.getName() + worked_process + profession.getName();
        return work;
    }


}
