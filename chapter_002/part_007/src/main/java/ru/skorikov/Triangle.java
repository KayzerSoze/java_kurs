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
     * Поле класса.
     */
    private StringBuilder sb = new StringBuilder();

    /**
     * Метод создающий треугольник.
     * @return треугольник.
     */
    public String pic() {
        for (int i = 0; i < 10; i++) {
            sb.append(" + ");
            for (int j = 0; j < i; j++) {
                sb.append("+ ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
