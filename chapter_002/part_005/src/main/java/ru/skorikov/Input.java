package ru.skorikov;

/**
 * Интерфейс Input.
 *
 * @author Alexey Skorikov
 * @version 1.0
 * @since 13.11.2016
 */
public interface Input {
    /**
     * Метод получает параметром строку.
     *
     * @param question параметр
     * @return зависит от параметра
     */
    String ask(String question);

}