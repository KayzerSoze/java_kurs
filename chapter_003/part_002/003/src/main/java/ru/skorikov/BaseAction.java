package ru.skorikov;


/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex Skorikov.
 * @ date: 29.07.17
 * @ version Stady_2.
 */
public abstract class BaseAction implements UserAction {
    /**
     * Поля класса.
     * имя.
     */
    private String name;
    /**
     * Поле класса
     * ключ.
     */
    private int key;

    /**
     * Получаем ключ.
     *
     * @return ключ.
     */
    public int key() {
        return key;
    }

    /**
     * Получаем имя..
     *
     * @return имя..
     */

    public String name() {
        return name;
    }

    /**
     * Реализованный метод интерфейса UserAction.
     *
     * @return строку из ключа и имени.
     */
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }

    /**
     * Конструктор класса.
     *
     * @param name имя.
     * @param key  ключ.
     */
    public BaseAction(String name, int key) {
        this.name = name;
        this.key = key;
    }

}
