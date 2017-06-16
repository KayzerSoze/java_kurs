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
     * Поле класса.
     * Хранит возвращаемую фигуру.
     */
    private StringBuilder sb = new StringBuilder();
    /**
     * Метод отрисовывающий квадрат.
     * @return квадрат.
     */
    public String pic() {
        for (int i = 0; i < 10; i++) {
            sb.append(" + + + + + + + + + + \n");
        }
        return sb.toString();
    }

}
