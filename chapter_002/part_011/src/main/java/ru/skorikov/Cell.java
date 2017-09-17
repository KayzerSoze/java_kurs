package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 04.09.17
 * @ version Stady_2.
 * Тестовое задание.
 * Класс описывает ячейку доски.
 */
public class Cell {
    /**
     * Цвет ячейки.
     */
    private String color;
    /**
     * Имя ячейки.
     */
    private String name;
    /**
     * Содержит ли ячейка фигуру.
     */
    private boolean isFigure;
    /**
     * Тип фигуры на ячейке.
     */
    private Figure figure;
    /**
     * Цифровое представление ячейки на доске по вертикали.
     */
    private int positionI;
    /**
     * Цифровое представление ячейки на доске по горизонтали..
     */
    private int positionJ;
    /**
     * Массив char для формиирования доски.
     */
    private char[] charForCell = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    /**
     * Массив int для формирования доски.
     */
    private int[] numberForCell = new int[]{8, 7, 6, 5, 4, 3, 2, 1};

    /**
     * Конструктор.
     *
     * @param name имя.
     *             Принимает имя ячейки и задает ее положение в "цифровом"виде.
     */
    public Cell(String name) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((String.valueOf(charForCell[j]) + String.valueOf(numberForCell[i])).equals(name)) {
                    this.positionI = i;
                    this.positionJ = j;

                }
            }
        }
        this.name = name;
    }

    /**
     * Конструктор.
     *
     * @param positionI позиция из массива.
     * @param positionJ позиция из массива.
     *                  Принимает положение ячейки на доске и задает имя.
     */
    public Cell(int positionI, int positionJ) {
        this.positionI = positionI;
        this.positionJ = positionJ;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((j == positionJ) && (i == positionI)) {
                    this.name = String.valueOf(charForCell[j]) + String.valueOf(numberForCell[i]);
                    break;
                }
            }
        }
    }

    /**
     * Получить цвет ячейки.
     *
     * @return цвет.
     */
    public String getColor() {
        return color;
    }

    /**
     * Получить имя ячейки.
     *
     * @return имя.
     */
    public String getName() {
        return name;
    }

    /**
     * Проверка наличия фигуры.
     *
     * @return boolean.
     */
    public boolean isFigure() {
        return isFigure;
    }

    /**
     * Получить вертикальный номер моложения ячейки.
     *
     * @return int.
     */
    public int getPositionI() {
        return positionI;
    }

    /**
     * Получить горизонтальный номер положения ячейки.
     *
     * @return int.
     */
    public int getPositionJ() {
        return positionJ;
    }

    /**
     * "Установить" на ячейку фигуру.
     *
     * @param figure boolean.
     */
    public void setFigure(boolean figure) {
        isFigure = figure;
    }

    /**
     * Получить тип фигуры на ячейке.
     *
     * @return тип фигуры.
     */
    public Figure getFigure() {
        return figure;
    }

    /**
     * "Установить" тип фигуры на ячейку.
     *
     * @param figure тип фигуры.
     */
    public void setFigure(Figure figure) {
        this.figure = figure;
    }
}
