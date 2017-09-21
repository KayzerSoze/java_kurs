package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 04.09.17
 * @ version Stady_2.
 * Пакет 1 часть 3 задание 2-2
 * Написать программу преобразования List в Map
 * Класс User.
 */

public class User {
    /**
     * Поле Id.
     */
    private int id;
    /**
     * Поле имя.
     */
    private String name;
    /**
     * Поле город.
     */
    private String sity;

    /**
     * Конструктор_1.
     *
     * @param id   ID.
     * @param name имя.
     * @param sity город.
     */
    public User(int id, String name, String sity) {
        this.id = id;
        this.name = name;
        this.sity = sity;
    }

    /**
     * Конструктор_2.
     *
     * @param name имя.
     * @param sity город.
     */
    public User(String name, String sity) {
        this.name = name;
        this.sity = sity;
    }

    /**
     * Получить ID.
     *
     * @return ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Присвоить ID.
     *
     * @param id ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Получить Имя.
     *
     * @return Имя.
     */
    public String getName() {
        return name;
    }

    /**
     * Задать имя.
     *
     * @param name Имя.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получить город.
     *
     * @return город.
     */
    public String getSity() {
        return sity;
    }

    /**
     * Задать город.
     *
     * @param sity город.
     */
    public void setSity(String sity) {
        this.sity = sity;
    }

    /**
     * Переопределяем метод equals.
     * Как я понял - объекты будут равны если
     * одновременно будут равны ID, name & sity объектов.
     *
     * @param o объект.
     * @return равны или нет.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (id != user.id) {
            return false;
        }
        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return sity != null ? sity.equals(user.sity) : user.sity == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sity != null ? sity.hashCode() : 0);
        return result;
    }
}
