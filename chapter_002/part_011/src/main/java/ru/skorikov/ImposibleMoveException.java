package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 04.09.17
 * @ version Stady_2.
 * Тестовое задание.
 * Класс ошибка наследник класса Exception.
 */
public class ImposibleMoveException extends Exception {
    /**
     * Сообщение об ошибке.
     * @param message сообщение.
     */
    public ImposibleMoveException(String message) {
        System.out.println(message);
    }
}
