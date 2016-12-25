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
     * Массив значений номеров меню.
     */
    private int [] range;
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
    public StubInput(String[] atAnswers, int[] atRange){
        this.answers = atAnswers;
        this.range = atRange;
    }
    public int ask(String question, int[] range){
        return range[position++];
    }
}