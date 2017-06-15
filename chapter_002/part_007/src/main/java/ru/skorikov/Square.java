package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex Skorikov.
 * @ date: 10.06.17
 * @ version Stady_2.
 * Класс рисующий квадрат.
 */
public class Square implements Share {
    /**
     * Метод рисует квадрат.
     * @return квадрат.
     */
    private StringBuilder sb = new StringBuilder();
    /**
     * Элемент построения фигуры.
     */
    private String element = " + + + + + + + + + + ";

    /**
     * Метод отрисовывающий квадрат.
     * @return квадрат.
     */
    public String pic() {
        sb.append(element);
        for (int i = 0; i < 10; i++) {
            System.out.println(sb);
        }
        return sb.toString();
    }

}
