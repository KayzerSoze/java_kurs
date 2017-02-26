package ru.skorikov;

/**
 * Интерфейс UserAction.
 *
 * @author Alexey Skorikov
 * @version 1.0
 * @since 20.11.2016
 */
public interface UserAction {
    /**
     * Ключ для доступа к методу execute.
     * @return ключ
     */
    int key();

    /**
     * Метод.
     * @param input ввод
     * @param tracker трекер
     */
    void execute(Input input, Tracker tracker);

    /**
     * Строка на экран.
     * @return строка
     */
    String info();
}
