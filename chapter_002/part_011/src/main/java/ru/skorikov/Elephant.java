package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 04.09.17
 * @ version Stady_2.
 * Тестовое задание.
 * Класс Слон наследник фигуры..
 */
public class Elephant extends Figure {
    /**
     * Поле - положение на доске.
     */
    private int posI, posJ;

    /**
     * Конструктор.
     *
     * @param position позиция.
     * @param name     имя.
     * @param color    цвет.
     */
    public Elephant(Cell position, String name, String color) {
        super(position, name, color);
        this.posI = position.getPositionI();
        this.posJ = position.getPositionJ();
    }

    /**
     * Переопределенный метод.
     *
     * @param dist ячейка куда идем.
     * @return массив ячеек которые нужно пройти.
     * @throws ImposibleMoveException сообщение об ощибке.
     */
    @Override
    public Cell[] way(Cell dist) throws ImposibleMoveException {
        //Слон ходит по диагонали на произвольное количество ячеек.
        //т.е номера ячеек по горизонтали и вертикали должны различаться равномерно.
        Cell[] wayElephant = null;
        int start = (Math.abs(dist.getPositionI() - posI));
        int finish = (Math.abs(dist.getPositionJ() - posJ));
        //Проверяем может ли так ходить слон.
        if ((finish == start) && (finish > 0)) {
            wayElephant = new Cell[Math.abs(dist.getPositionI() - posI)];
            //Заполняем массив в зависимости от того в какую четверть доски
            //двигается фигура.
            if (dist.getPositionI() < posI) {
                if (dist.getPositionJ() < posJ) {
                    for (int i = 0; i < wayElephant.length; i++) {
                        wayElephant[i] = new Cell(posI - 1 - i,
                                posJ - 1 - i);
                    }
                } else {
                    for (int i = 0; i < wayElephant.length; i++) {
                        wayElephant[i] = new Cell(posI - 1 - i,
                                posJ + 1 + i);
                    }
                }
            } else {
                if (dist.getPositionJ() < posJ) {
                    for (int i = 0; i < wayElephant.length; i++) {
                        wayElephant[i] = new Cell(posI + 1 + i,
                                posJ - 1 - i);
                    }
                } else {
                    for (int i = 0; i < wayElephant.length; i++) {
                        wayElephant[i] = new Cell(posI + 1 + i,
                                posJ + 1 + i);
                    }
                }
            }

        } else {
            throw new ImposibleMoveException("Не могу так ходить.");
        }
        return wayElephant;
    }


}
