package ru.skorikov;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 04.09.17
 * @ version Stady_2.
 * Тестовое задание.
 * Класс проверяет поведение фигуры.
 */
public class ElephantTest {
    /**
     * Поле класса.
     */
    private static Figure figure;

    /**
     * Перед каждым тестом создаем новую фигуру.
     */
    @BeforeClass
    public static void testRun() {
        figure = new Elephant(new Cell("e4"), "Slon", "Black");
    }

    /**
     * Для проверки исключений.
     */
    @Rule
    public final ExpectedException exp = ExpectedException.none();

    /**
     * Проверяем сооответствие длинн пути
     * предполагаемого и фактического.
     *
     * @throws ImposibleMoveException исключение.
     */

    @Test
    public void whenWayIsTrueReturnWay() throws ImposibleMoveException {
        Cell[] cell = new Cell[]{new Cell("f5"), new Cell("g6"), new Cell("h7")};
        Cell[] expectedWay = figure.way(new Cell("h7"));
        Assert.assertEquals(cell.length, expectedWay.length);
    }

    /**
     * Проверим что передполагаемый путь состоит из тех же ячеек
     * что и фактический.
     *
     * @throws ImposibleMoveException исключение.
     */

    @Test
    public void whenWayIsTrueReturnWayForCell() throws ImposibleMoveException {
        Cell[] cell = new Cell[]{new Cell("f5"), new Cell("g6"), new Cell("h7")};
        Cell[] expectedWay = figure.way(new Cell("h7"));
        for (int i = 0; i < cell.length; i++) {
            Assert.assertEquals(cell[i].getName(), expectedWay[i].getName());
        }
    }

    /**
     * Проверим что упадет исключение если фигура не может так ходить.
     * @throws ImposibleMoveException исключение.
     */

    @Test
    public void whenReturnException() throws ImposibleMoveException {
        exp.expect(ImposibleMoveException.class);
        Cell[] expectedWay = figure.way(new Cell("b4"));

    }
}