package ru.skorikov;
/**
 * Created with IntelliJ IDEA.
 * @author: Alex Skorikov.
 * @date: 07.04.17
 * @version Stady_2.
 *
 */
public class Doctor extends  Profession {
    /**
     * Переаттестация.
     */
    private String training;

    /**
     * Получить наличие переаттестации.
     * @return переаттестация.
     */
    public String getTraining() {
        return training;
    }

    /**
     * Установить значение переттестации.
     * @param training преаттестация.
     */
    public void setTraining(String training) {
        this.training = training;
    }

    /**
     * Наследование из родительского класса переменной имя.
     * @param name имя.
     */
    public Doctor(String name) {
        super(name);
    }

    /**
     * Переопределенный метод родительского класса.
     * @param profession Принимает экземпляр класса Profession.
     * @return Рабочий "процесс" доктора.
     */
    @Override
    public String work(Profession profession) {
        String workedProcess = " лечит ";
        return super.getName() + workedProcess + profession.getName();
    }

}
