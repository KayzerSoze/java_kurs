package ru.skorikov;

/**
 * Класс эмулирует поведение пользователя.
 * (отвечает на вопросы)
 *
 * @author Alexey Skorikov
 * @version 1.0
 * @since 13.11.2016
 */
public class StubInput implements Input {
    /**
     * Массив ответов.
     */
    private String[] answers;
    /**
     * счетчик.
     */
    private int position = 0;

    /**
     * Конструктор Массив ответов на вопросы программы.
     *
     * @param atAnswers ответ
     */
    public StubInput(String[] atAnswers) {
        this.answers = atAnswers;
    }

    /**
     * Выдает ответы на вопросы программы по очереди.
     *
     * @param question вопро программы
     * @return ответ из масива
     */
    public String ask(String question) {
        return answers[position++];
    }
}