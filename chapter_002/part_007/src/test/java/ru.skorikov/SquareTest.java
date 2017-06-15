package ru.skorikov;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex Skorikov.
 * @ date: 10.06.17
 * @ version Stady_2.
 */
public class SquareTest {
    /**
     * Переопределяем выходной поток.
     */
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    /**
     * Метод выполнится перед любым @Test.
     */
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenDrawSqurethenShowSqure() {

        Paint paint = new Paint();
        Square square = new Square();
        paint.draw(square.pic());

        assertEquals(
                " + + + + + + + + + + \n"
                        + " + + + + + + + + + + \n"
                        + " + + + + + + + + + + \n"
                        + " + + + + + + + + + + \n"
                        + " + + + + + + + + + + \n"
                        + " + + + + + + + + + + \n"
                        + " + + + + + + + + + + \n"
                        + " + + + + + + + + + + \n"
                        + " + + + + + + + + + + \n"
                        + " + + + + + + + + + + \n", outContent.toString());

    }
}