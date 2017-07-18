package ru.skorikov;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex Skorikov.
 * @ date: 10.05.17
 * @ version Stady_2.
 */
public class ConsoleInput implements Input {
    /**
     * Инструмент ввода с консоли.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Реализацияя интерфейса Input.
     *
     * @param question вопрос.
     * @return ответ.
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

}
