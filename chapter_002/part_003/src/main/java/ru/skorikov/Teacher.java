package ru.skorikov;
/**
 * Created with IntelliJ IDEA.
 * @author: Alex Skorikov
 * @date: 07.04.17
 * @version Stady_2
 *
 */
public class Teacher extends Profession {
    /**
     * Ученая степень.
     */
    private String academicDegree;

    /**
     * Получить наличие ученой степени.
     * @return ученая степень.
     */
    public String getAcademicDegree() {
        return academicDegree;
    }

    /**
     * Установить значение ученой степени.
     * @param academicDegree ученая степень.
     */
    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    /**
     * Наследование из родительского класса переменной имя.
     * @param name имя.
     */
    public Teacher(String name) {
        super(name);
    }

    /**
     * Переопределенный метод родительского класса.
     * @param profession Принимает экземпляр класса Profession.
     * @return Рабочий "процесс" учителя.
     */
    @Override
    public String work(Profession profession) {
        String workedProcess = " учит ";
        return super.getName() + workedProcess + profession.getName();
    }


}
