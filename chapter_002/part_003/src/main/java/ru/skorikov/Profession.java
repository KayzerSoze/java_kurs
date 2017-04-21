package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 * @author: Alex Skorikov.
 * @date: 07.04.17
 * @version Stady_2.
 * Класс описывает профессию.
 *
 */
public class Profession {
    /**
     * Экземпляр класса имеет переменную имя.
     */
    private String name;
    /**
     * Наличие диплома.
     */
    private String diplom;
    /**
     * Возраст.
     */
    private int age;
    /**
     * Трудовой опыт или стаж.
     */
    private int workedTime;

    /**
     * Конструктор класса.
     * @param name имя.
     * @param diplom наличие диплома.
     * @param age возраст.
     * @param workedTime трудовой стаж.
     */
    public Profession(String name, String diplom, int age, int workedTime) {
        this.name = name;
        this.diplom = diplom;
        this.age = age;
        this.workedTime = workedTime;
    }

    /**
     * Переопределенный конструктор класса.
     * @param name имя.
     */
    public Profession(String name) {
        this.name = name;
    }

    /**
     * Метод класса возвращает строку.
     * @param profession принимает экземпляр класса Profession.
     * @return строка
     */
    public String work(Profession profession) {
        return name + profession.getName();
    }

    /**
     * Получаем имя.
     * @return имя.
     */
    String getName() {
        return name;
    }

    /**
     * Задать имя.
     * @param name имя.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получить диплом.
     * @return диплом.
     */
    public String getDiplom() {
        return diplom;
    }

    /**
     * Задать диплом.
     * @param diplom диплом.
     */
    public void setDiplom(String diplom) {
        this.diplom = diplom;
    }

    /**
     * Получить возраст.
     * @return возраст.
     */
    public int getAge() {
        return age;
    }

    /**
     * Задать возраст.
     * @param age возраст.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Получить значение опыта.
     * @return опыт.
     */
    public int getWorkedTime() {
        return workedTime;
    }

    /**
     * Задать значение опыта.
     * @param workedTime опыт.
     */
    public void setWorkedTime(int workedTime) {
        this.workedTime = workedTime;
    }

}
