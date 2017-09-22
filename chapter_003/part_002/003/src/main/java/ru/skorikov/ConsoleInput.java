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
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
    /**
     * Метод выводит вопрос.
     * ожидает ответ пользователя
     *
     * @param question вопрос
     * @param range    диапазон
     * @return ответ
     */
    @Override
    public int ask(String question, int[] range) throws MenuOutException {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out from range.");
        }
    }

}
