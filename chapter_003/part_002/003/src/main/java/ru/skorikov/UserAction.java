package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex Skorikov.
 * @ date: 17.07.17
 * @ version Stady_2.
 */
public interface UserAction {
    /**
     * Ключ для доступа к методу execute.
     *
     * @return ключ
     */
    int key();

    /**
     * Метод.
     *
     * @param input   ввод
     * @param tracker трекер
     */
    void execute(Input input, Tracker tracker);

    /**
     * Строка на экран.
     *
     * @return строка
     */
    String info();

}
