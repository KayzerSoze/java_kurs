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
 * Класс проверяет поведение доски.
 */
public class BoardTest {
    /**
     * Поле класса.
     * Класс доска.
     */
    private static Board board;

    /**
     * Перед каждым тестом - новая доска.
     */
    @BeforeClass
    public static void testRun() {
        board = new Board();

//        board.getFigures()[0] = new Elephant(board.getCellsBoard()[4][4], "Slon", "Black");
//        board.getFigures()[1] = new Elephant(board.getCellsBoard()[3][3],"Slon","White");

    }

    /**
     * Для проверки исключений.
     */
    @Rule
    public final ExpectedException exp = ExpectedException.none();

    /**
     * Проверим что в ячейке нет фигуры.
     *
     * @throws Exception исключение.
     */
    @Test
    public void isFigureOutCell() throws Exception {
        exp.expect(Board.FigureNotFoundException.class);
        board.move(board.getCellsBoard()[5][3], board.getCellsBoard()[6][2]);
    }

    /**
     * Проверим что в ячейке есть фигура.
     *
     * @throws Exception исключение.
     */
    @Test
    public void isFigureOnCell() throws Exception {
        board.getFigures()[0] = new Elephant(board.getCellsBoard()[4][4], "Slon", "Black");
        Cell cell = board.getCellsBoard()[4][4];
        Assert.assertTrue(cell.isFigure());
    }

    /**
     * Проверим - путь свободен.
     *
     * @throws Exception исключение.
     */
    @Test
    public void isWayFree() throws Exception {
        Assert.assertTrue(board.move(board.getCellsBoard()[4][4], board.getCellsBoard()[7][7]));
    }

    /**
     * Проверим - путь не свободен.
     *
     * @throws Exception исключение.
     */
    @Test
    public void isWayNotFree() throws Exception {
        board.getFigures()[0] = new Elephant(board.getCellsBoard()[4][4], "Slon", "Black");
        board.getFigures()[1] = new Elephant(board.getCellsBoard()[3][3], "Slon", "White");
        exp.expect(Board.OccupiedWayException.class);
        board.move(board.getCellsBoard()[4][4], board.getCellsBoard()[2][2]);
    }

    /**
     * Проверим что фигура заняла новое положение.
     *
     * @throws Exception исключение.
     */
    @Test
    public void isFigureOnNewPosition() throws Exception {
        board.getFigures()[0] = new Elephant(board.getCellsBoard()[4][4], "Slon", "Black");
        board.getFigures()[1] = new Elephant(board.getCellsBoard()[3][3], "Slon", "White");
        board.move(board.getCellsBoard()[4][4], board.getCellsBoard()[1][7]);
        String name = board.getCellsBoard()[1][7].getFigure().toString();
        Assert.assertEquals(board.getCellsBoard()[1][7].getFigure().toString(), name);
    }

}