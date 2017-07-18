package ru.skorikov;


/**
 * Created with IntelliJ IDEA.
 * Класс эмулирует ответы пользователя на
 * запросы программы.
 *
 * @ author: Alex Skorikov.
 * @ date: 05.06.17
 * @ version Stady_2.
 */

/**
 * Класс реализует интерфейс Input.
 */
public class StubInput implements Input {
    /**
     * Массив ответов на вопросы программы.
     */
    private String[] answers;
    /**
     * Счетчик перемещения по массиву.
     */
    private int position = 0;

    /**
     * Конструктор класса.
     * Принимает массив ответов.
     *
     * @param answers массив ответов.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Метод класса.
     * Принимает вопрос программы.
     * возвращает ответ из массива.
     *
     * @param question выводит вопрос.
     * @return ответ из массива.
     */
    public String ask(String question) {
        return answers[position++];
    }
}
