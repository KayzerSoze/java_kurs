package ru.skorikov;
import java.util.Scanner;

/**
 * Класс Ввод с консоли.
 * задает вопрос и получает ответ пользователя
 *
 * @author Alexey Skorikov
 * @version 2.0
 * @since 13.11.2016
 */
public class ConsoleInput implements Input {
    /**
     * Новый экземпляр класса Scanner.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Метод выводит Вопрос.
     * и ожидает Ответ от пользователя
     *
     * @param question вопрос
     * @return ответ
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
    /**
     * Метод выводит вопрос.
     * ожидает ответ пользователя
     * 
     * @param question вопрос
     * @param range диапазон
     * @return ответ
     */
    public String ask(String question, int range) {
        System.out.println(question);
        return scanner.nextLine();
    }

}