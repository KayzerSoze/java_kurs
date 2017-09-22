package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 04.09.17
 * @ version Stady_2.
 * Пакет 1 часть 3 задание 3-1
 * Организовать сортировку User
 * Класс User.
 */
public class User implements Comparable<User> {
    /**
     * Имя.
     */
    private String name;
    /**
     * Возраст.
     */
    private int age;

    /**
     * Конструктор.
     * @param name имя.
     * @param age возраст.
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Получить имя.
     * @return имя.
     */
    public String getName() {
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

    @Override
    public int compareTo(User o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", age=" + age
                + '}';
    }
}
