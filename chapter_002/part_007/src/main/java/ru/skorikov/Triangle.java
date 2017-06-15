package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex Skorikov.
 * @ date: 10.06.17
 * @ version Stady_2.
 * Класс рисующий треугольник.
 */
public class Triangle implements Share {
    /**
     * Метод рисует треугольник.
     * @return треугольник.
     */
    private StringBuilder sb = new StringBuilder();
    /**
     * Элемент построения фигуры.
     */
    private String element = " +";

    /**
     * Метод отрисовывающий треугольник.
     * @return треугольник.
     */
    public String pic() {
        sb.append(element);
        for (int i = 0; i < 10; i++) {
            System.out.println(sb);
            sb.append(element);
        }

        return sb.toString();
    }

}
