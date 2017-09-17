package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 04.09.17
 * @ version Stady_2.
 * Тестовое задание.
 * Класс доска.
 */

public class Board {
    /**
     * Поле массив фигур.
     */
    private Figure[] figures = new Figure[32];

    /**
     * Поле двумерный массив ячеек.
     */
    private Cell[][] cellsBoard = new Cell[8][8];

    /**
     * Конструктор доски.
     */
    public Board() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Cell cell = new Cell(i, j);
                cellsBoard[i][j] = cell;
            }
        }
//        figures[0] = new Elephant(cellsBoard[4][4], "Slon", "Black");
//        figures[1] = new Elephant(cellsBoard[2][2], "Slon", "Black");
    }

    /**
     * Получить фигуры доски.
     * @return фигуры.
     */
    public Figure[] getFigures() {
        return figures;
    }

    /**
     * Получить массив ячеек доски.
     *
     * @return массив ячеек.
     */
    public Cell[][] getCellsBoard() {
        return cellsBoard;
    }

    /**
     * Метод движения фигуры.
     *
     * @param source ячейка откуда движемся.
     * @param dist   ячейка куда движемся.
     * @return можем ли так двигаться.
     * @throws ImposibleMoveException         исключение - не можем так двигаться.
     * @throws OccupiedWayException           исключение - путь занят.
     * @throws FigureNotFoundException        исключение - отсутствует фигура.
     * @throws ArrayIndexOutOfBoundsException выход за пределы доски.
     */

    public boolean move(Cell source, Cell dist)
            throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException, ArrayIndexOutOfBoundsException {
        boolean isMove = true;

        if (!source.isFigure()) {
            isMove = false;
            throw new FigureNotFoundException("Некому ходить.");
        } else {

            Cell[] cells = source.getFigure().way(dist);
            for (int i = 0; i < cells.length;) {
                int anI = cells[i].getPositionI();
                int anJ = cells[i].getPositionJ();
                if (cellsBoard[anI][anJ].getFigure() == null) {
                    i++;
                } else {
                    isMove = false;
                    throw new OccupiedWayException("Путь занят.");
                }
            }

            if (isMove) {
                dist.setFigure(source.getFigure());
                dist.setFigure(true);
                source.setFigure(null);
                source.setFigure(false);
            }
        }
        return isMove;
    }

    /**
     * Класс-наследник Exception.
     * путь занят.
     */
    protected class OccupiedWayException extends Exception {
        /**
         * Сообщение об ошибке.
         * @param message сообщение.
         */
        public OccupiedWayException(String message) {
            super(message);
        }
    }

    /**
     * Класс-наследник Eception.
     * на ячейке нет фигуры.
     */
    protected class FigureNotFoundException extends Exception {
        /**
         * Сообщение об ошибке.
         * @param message сообщение.
         */
        public FigureNotFoundException(String message) {
            super(message);
        }
    }

}
