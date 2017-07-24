package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex Skorikov.
 * @ date: 24.07.17
 * @ version Stady_2.
 */

public class MenuOutException extends Exception {
    /**
     * Метод возвращает сообщение об ошибке родительского класса.
     * @param msg сообщение.
     */
    public MenuOutException(String msg) {
        super(msg);

    }
}
