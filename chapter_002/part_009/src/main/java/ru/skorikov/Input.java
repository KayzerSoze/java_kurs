package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex Skorikov.
 * @ date: 10.05.17
 * @ version Stady_2.
 */
public interface Input {
    /**
     * Метод полчает парметром строку.
     *
     * @param question выводит вопрос.
     * @return возвращает ответ пользователя.
     */
    String ask(String question);

    /**
     * Метод получает параметром строку и диапазон значений.
     *
     * @param question выводит вопрос.
     * @param rahge    выбирает из диапазона.
     * @return ответ.
     * @throws MenuOutException сообщение о ошибке.
     */
    int ask(String question, int[] rahge) throws MenuOutException;

}
