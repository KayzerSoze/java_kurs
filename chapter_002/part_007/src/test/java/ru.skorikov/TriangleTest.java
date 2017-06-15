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

/**
 * Класс тестирующий класс Triangle.
 */
public class TriangleTest {
    /**
     * Переопределяем выходной поток.
     */
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    /**
     * То, что выполнится перед любым @Test.
     */
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    /**
     * Тестовый метод.
     */
    @Test
    public void whenDrawTrianglethenShowSqure() {

        Paint paint = new Paint();
        Triangle triangle = new Triangle();
        paint.draw(triangle.pic());

        assertEquals(
                " +\n"
                        + " + +\n"
                        + " + + +\n"
                        + " + + + +\n"
                        + " + + + + +\n"
                        + " + + + + + +\n"
                        + " + + + + + + +\n"
                        + " + + + + + + + +\n"
                        + " + + + + + + + + +\n"
                        + " + + + + + + + + + +\n", outContent.toString());

    }

}