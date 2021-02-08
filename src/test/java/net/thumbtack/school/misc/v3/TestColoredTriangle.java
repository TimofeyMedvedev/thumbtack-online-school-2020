package net.thumbtack.school.misc.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.figures.v3.Point;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class TestColoredTriangle {
    @Test
    public void testColoredTriangle1() throws ColorException {
        Point firstPoint = new Point(10, 20);
        Point secondPoint = new Point(30, 40);
        Point thirdPoint = new Point(50, 60);
        ColoredTriangle triangle = new ColoredTriangle(firstPoint, secondPoint, thirdPoint, Color.BLUE);
        assertAll(
                () -> assertEquals(10, triangle.getFirstPoint().getX()),
                () -> assertEquals(20, triangle.getFirstPoint().getY()),
                () -> assertEquals(30, triangle.getSecondPoint().getX()),
                () -> assertEquals(40, triangle.getSecondPoint().getY()),
                () -> assertEquals(50, triangle.getThirdPoint().getX()),
                () -> assertEquals(60, triangle.getThirdPoint().getY()),
                () -> assertEquals(Color.BLUE, triangle.getColor())
        );
    }

    @Test
    public void testColoredTriangle2() throws ColorException {
        ColoredTriangle triangle = new ColoredTriangle(10, 20, 30, 40, 50 ,60, Color.BLUE);
        assertAll(
                () -> assertEquals(10, triangle.getFirstPoint().getX()),
                () -> assertEquals(20, triangle.getFirstPoint().getY()),
                () -> assertEquals(30, triangle.getSecondPoint().getX()),
                () -> assertEquals(40, triangle.getSecondPoint().getY()),
                () -> assertEquals(50, triangle.getThirdPoint().getX()),
                () -> assertEquals(60, triangle.getThirdPoint().getY()),
                () -> assertEquals(Color.BLUE, triangle.getColor())
        );
    }

    @Test
    public void testColoredTriangle3() throws ColorException {
        ColoredTriangle triangle = new ColoredTriangle(20, Color.BLUE);
        assertAll(
                () -> assertEquals(0, triangle.getFirstPoint().getX()),
                () -> assertEquals(0, triangle.getFirstPoint().getY()),
                () -> assertEquals(0, triangle.getSecondPoint().getX()),
                () -> assertEquals(-20, triangle.getSecondPoint().getY()),
                () -> assertEquals(20, triangle.getThirdPoint().getX()),
                () -> assertEquals(0, triangle.getThirdPoint().getY()),
                () -> assertEquals(Color.BLUE, triangle.getColor())
        );
    }

    @Test
    public void testColoredTriangle4() throws ColorException {
        ColoredTriangle triangle = new ColoredTriangle(Color.BLUE);
        assertAll(
                () -> assertEquals(0, triangle.getFirstPoint().getX()),
                () -> assertEquals(0, triangle.getFirstPoint().getY()),
                () -> assertEquals(0, triangle.getSecondPoint().getX()),
                () -> assertEquals(-1, triangle.getSecondPoint().getY()),
                () -> assertEquals(1, triangle.getThirdPoint().getX()),
                () -> assertEquals(0, triangle.getThirdPoint().getY()),
                () -> assertEquals(Color.BLUE, triangle.getColor())
        );
    }

    @Test
    public void testColoredTriangle5() throws ColorException {
        ColoredTriangle triangle = new ColoredTriangle();
        assertAll(
                () -> assertEquals(0, triangle.getFirstPoint().getX()),
                () -> assertEquals(0, triangle.getFirstPoint().getY()),
                () -> assertEquals(0, triangle.getSecondPoint().getX()),
                () -> assertEquals(-1, triangle.getSecondPoint().getY()),
                () -> assertEquals(1, triangle.getThirdPoint().getX()),
                () -> assertEquals(0, triangle.getThirdPoint().getY()),
                () -> assertEquals(Color.GREEN, triangle.getColor())
        );
    }

    @Test
    public void testColoredTriangle6() throws ColorException {
        Point firstPoint = new Point(10, 20);
        Point secondPoint = new Point(30, 40);
        Point thirdPoint = new Point(50, 60);
        ColoredTriangle triangle = new ColoredTriangle(firstPoint, secondPoint, thirdPoint, "RED");
        assertAll(
                () -> assertEquals(10, triangle.getFirstPoint().getX()),
                () -> assertEquals(20, triangle.getFirstPoint().getY()),
                () -> assertEquals(30, triangle.getSecondPoint().getX()),
                () -> assertEquals(40, triangle.getSecondPoint().getY()),
                () -> assertEquals(50, triangle.getThirdPoint().getX()),
                () -> assertEquals(60, triangle.getThirdPoint().getY()),
                () -> assertEquals(Color.RED, triangle.getColor())
        );
    }

    @Test
    public void testColoredTriangle7() throws ColorException {
        ColoredTriangle triangle = new ColoredTriangle(10, 20, 30, 40, 50 ,60, "GREEN");
        assertAll(
                () -> assertEquals(10, triangle.getFirstPoint().getX()),
                () -> assertEquals(20, triangle.getFirstPoint().getY()),
                () -> assertEquals(30, triangle.getSecondPoint().getX()),
                () -> assertEquals(40, triangle.getSecondPoint().getY()),
                () -> assertEquals(50, triangle.getThirdPoint().getX()),
                () -> assertEquals(60, triangle.getThirdPoint().getY()),
                () -> assertEquals(Color.GREEN, triangle.getColor())
        );
    }

    @Test
    public void testColoredTriangle8() throws ColorException {
        ColoredTriangle triangle = new ColoredTriangle(20, "BLUE");
        assertAll(
                () -> assertEquals(0, triangle.getFirstPoint().getX()),
                () -> assertEquals(0, triangle.getFirstPoint().getY()),
                () -> assertEquals(0, triangle.getSecondPoint().getX()),
                () -> assertEquals(-20, triangle.getSecondPoint().getY()),
                () -> assertEquals(20, triangle.getThirdPoint().getX()),
                () -> assertEquals(0, triangle.getThirdPoint().getY()),
                () -> assertEquals(Color.BLUE, triangle.getColor())
        );
    }

    @Test
    public void testColoredTriangle9() throws ColorException {
        ColoredTriangle triangle = new ColoredTriangle("BLUE");
        assertAll(
                () -> assertEquals(0, triangle.getFirstPoint().getX()),
                () -> assertEquals(0, triangle.getFirstPoint().getY()),
                () -> assertEquals(0, triangle.getSecondPoint().getX()),
                () -> assertEquals(-1, triangle.getSecondPoint().getY()),
                () -> assertEquals(1, triangle.getThirdPoint().getX()),
                () -> assertEquals(0, triangle.getThirdPoint().getY()),
                () -> assertEquals(Color.BLUE, triangle.getColor())
        );
    }

    @Test
    public void testColoredTriangle10() throws ColorException {
        assertThrows(ColorException.class, () -> new ColoredTriangle((Color) null));
    }

    @Test
    public void testColoredTriangle11() throws ColorException {
        assertThrows(ColorException.class, () -> new ColoredTriangle((String) null));
    }

    @Test
    public void testSetColor1() throws ColorException {
        ColoredTriangle coloredTriangle = new ColoredTriangle(Color.GREEN);
        assertAll(
                () -> assertEquals(0, coloredTriangle.getFirstPoint().getX()),
                () -> assertEquals(0, coloredTriangle.getFirstPoint().getY()),
                () -> assertEquals(0, coloredTriangle.getSecondPoint().getX()),
                () -> assertEquals(-1, coloredTriangle.getSecondPoint().getY()),
                () -> assertEquals(1, coloredTriangle.getThirdPoint().getX()),
                () -> assertEquals(0, coloredTriangle.getThirdPoint().getY()),
                () -> assertEquals(Color.GREEN, coloredTriangle.getColor())
        );
        coloredTriangle.setColor(Color.BLUE);
        assertEquals(Color.BLUE, coloredTriangle.getColor());
    }

    @Test
    public void testSetColor2() throws ColorException {
        ColoredTriangle coloredTriangle = new ColoredTriangle("GREEN");
        assertAll(
                () -> assertEquals(0, coloredTriangle.getFirstPoint().getX()),
                () -> assertEquals(0, coloredTriangle.getFirstPoint().getY()),
                () -> assertEquals(0, coloredTriangle.getSecondPoint().getX()),
                () -> assertEquals(-1, coloredTriangle.getSecondPoint().getY()),
                () -> assertEquals(1, coloredTriangle.getThirdPoint().getX()),
                () -> assertEquals(0, coloredTriangle.getThirdPoint().getY()),
                () -> assertEquals(Color.GREEN, coloredTriangle.getColor())
        );
        coloredTriangle.setColor("BLUE");
        assertEquals(Color.BLUE, coloredTriangle.getColor());
    }

    @Test
    public void testSetColor3() throws ColorException {
        ColoredTriangle coloredTriangle = new ColoredTriangle("GREEN");
        assertAll(
                () -> assertEquals(0, coloredTriangle.getFirstPoint().getX()),
                () -> assertEquals(0, coloredTriangle.getFirstPoint().getY()),
                () -> assertEquals(0, coloredTriangle.getSecondPoint().getX()),
                () -> assertEquals(-1, coloredTriangle.getSecondPoint().getY()),
                () -> assertEquals(1, coloredTriangle.getThirdPoint().getX()),
                () -> assertEquals(0, coloredTriangle.getThirdPoint().getY()),
                () -> assertEquals(Color.GREEN, coloredTriangle.getColor())
        );
        assertThrows(ColorException.class, () -> coloredTriangle.setColor((Color) null));
    }

    @Test
    public void testSetColor4() throws ColorException {
        ColoredTriangle coloredTriangle = new ColoredTriangle("GREEN");
        assertAll(
                () -> assertEquals(0, coloredTriangle.getFirstPoint().getX()),
                () -> assertEquals(0, coloredTriangle.getFirstPoint().getY()),
                () -> assertEquals(0, coloredTriangle.getSecondPoint().getX()),
                () -> assertEquals(-1, coloredTriangle.getSecondPoint().getY()),
                () -> assertEquals(1, coloredTriangle.getThirdPoint().getX()),
                () -> assertEquals(0, coloredTriangle.getThirdPoint().getY()),
                () -> assertEquals(Color.GREEN, coloredTriangle.getColor())
        );
        assertThrows(ColorException.class, () -> coloredTriangle.setColor((String) null));
    }

    @Test
    public void testSetCoordinatesAndColor() throws ColorException {
        ColoredTriangle triangle = new ColoredTriangle(10, 20, 30, 40, 50 ,60, Color.BLUE);
        triangle.setFirstPoint(new Point(50, 60));
        triangle.setSecondPoint(new Point(100, 200));
        triangle.setThirdPoint(new Point(300, 400));
        triangle.setColor(Color.RED);
        assertAll(
                () -> assertEquals(50, triangle.getFirstPoint().getX()),
                () -> assertEquals(60, triangle.getFirstPoint().getY()),
                () -> assertEquals(100, triangle.getSecondPoint().getX()),
                () -> assertEquals(200, triangle.getSecondPoint().getY()),
                () -> assertEquals(300, triangle.getThirdPoint().getX()),
                () -> assertEquals(400, triangle.getThirdPoint().getY()),
                () -> assertEquals(Color.RED, triangle.getColor())
        );
    }

    @Test
    public void testMoveColoredTriangle() throws ColorException {
        ColoredTriangle triangle = new ColoredTriangle(10, 20, 30, 40, 50 ,60, Color.BLUE);
        triangle.moveRel(100, 50);
        assertAll(
                () -> assertEquals(110, triangle.getFirstPoint().getX()),
                () -> assertEquals(70, triangle.getFirstPoint().getY()),
                () -> assertEquals(130, triangle.getSecondPoint().getX()),
                () -> assertEquals(90, triangle.getSecondPoint().getY()),
                () -> assertEquals(150, triangle.getThirdPoint().getX()),
                () -> assertEquals(110, triangle.getThirdPoint().getY())
        );
        triangle.moveTo(100, 200);
        assertAll(
                () -> assertEquals(100, triangle.getFirstPoint().getX()),
                () -> assertEquals(200, triangle.getFirstPoint().getY()),
                () -> assertEquals(120, triangle.getSecondPoint().getX()),
                () -> assertEquals(220, triangle.getSecondPoint().getY()),
                () -> assertEquals(140, triangle.getThirdPoint().getX()),
                () -> assertEquals(240, triangle.getThirdPoint().getY())
        );
        triangle.moveTo(new Point(400, 600));
        assertAll(
                () -> assertEquals(400, triangle.getFirstPoint().getX()),
                () -> assertEquals(600, triangle.getFirstPoint().getY()),
                () -> assertEquals(420, triangle.getSecondPoint().getX()),
                () -> assertEquals(620, triangle.getSecondPoint().getY()),
                () -> assertEquals(440, triangle.getThirdPoint().getX()),
                () -> assertEquals(640, triangle.getThirdPoint().getY())
        );
    }

    @Test
    public void testEqualsColoredTriangle() throws ColorException {
        ColoredTriangle triangle1 = new ColoredTriangle(10, 20, 30, 40, 50 ,60, Color.BLUE);
        ColoredTriangle triangle2 = new ColoredTriangle(10, 20, 20, 40, 100 ,60, Color.BLUE);
        ColoredTriangle triangle3 = new ColoredTriangle(10, 20, 30, 40, 50 ,60, Color.BLUE);
        assertEquals(triangle1, triangle3);
        assertNotEquals(triangle1, triangle2);
    }
}
