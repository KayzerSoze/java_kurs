package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 04.09.17
 * @ version Stady_2.
 * Тестовое задание.
 * Абстрактный класс Фигура.
 */

public abstract class Figure {
    /**
     * Ячейка - позиция фигуры.
     */
    private final Cell position;
    /**
     * Имя фигуры.
     */
    private String name;
    /**
     * Цвет фигуры.
     */
    private String color;

    /**
     * Конструктор.
     *
     * @param position позиция.
     * @param name     имя.
     * @param color    цвет.
     */
    protected Figure(Cell position, String name, String color) {
        this.position = position;
        this.name = name;
        this.color = color;
        position.setFigure(true);
        position.setFigure(this);

    }

    /**
     * Путь который нужно пройти фигуре.
     *
     * @param dist ячейка куда идем.
     * @return массив ячеек которые нужно пройти.
     * @throws ImposibleMoveException исключение если пойти не можем.
     */
    public abstract Cell[] way(Cell dist) throws ImposibleMoveException;

}
