package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex Skorikov.
 * @ date: 10.06.17
 * @ version Stady_2.
 * Класс рисующий фигуры.
 * (запуск приложения)
 */

public class Paint {
    /**
     * Метод отрисовки фигуры.
     * @param share принимает фигуру.
     */
    public void draw(Share share) {
        System.out.print(share.pic());
    }
}
