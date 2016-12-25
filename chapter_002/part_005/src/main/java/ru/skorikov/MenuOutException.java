package ru.skorikov;

/**
 * Класс Обработки ошибок
 *
 * @author Alexey Skorikov
 * @version 1.0
 * @since 18.12.2016
 */
public class MenuOutException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuOutException(String msg){
        super(msg);
    }
}
