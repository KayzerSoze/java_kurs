package ru.skorikov;

/**
 * Класс Обработки ошибок
 *
 * @author Alexey Skorikov
 * @version 1.0
 * @since 18.12.2016
 */
public class MenuOutException extends RuntimeException {
    public MenuOutException(String msg){
        super( msg);
    }
}
