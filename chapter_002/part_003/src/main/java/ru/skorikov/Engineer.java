package ru.skorikov;
/**
 * Created with IntelliJ IDEA.
 * @author: Alex Skorikov.
 * @date: 07.04.17
 * @version Stady_2.
 *
 */
public class Engineer extends Profession {
    /**
     * Изобретения.
     */
    private String inventions;

    /**
     * Получить наличие изобретений.
     * @return изобретения.
     */
    public String getInventions() {
        return inventions;
    }

    /**
     * Установить наличие изобретений.
     * @param inventions изобретения.
     */
    public void setInventions(String inventions) {
        inventions = inventions;
    }

    /**
     * Наследование из родительского класса переменной имя.
     * @param name имя.
     */
    public Engineer(String name) {
        super(name);
    }

    /**
     * Переопределенный метод родительского класса.
     * @param profession Принимает экземпляр класса Profession.
     * @return Рабочий "процесс" инженера.
     */
    @Override
    public String work(Profession profession) {
        String workedProcess = " изобретает для ";
        return super.getName() + workedProcess + profession.getName();
    }

}
