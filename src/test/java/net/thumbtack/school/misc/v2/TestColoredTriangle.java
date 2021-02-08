package net.thumbtack.school.misc.v2;

import net.thumbtack.school.figures.v2.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestColoredTriangle {
    @Test
    public void testColoredTriangle1() {
        Point firstPoint = new Point(10, 20);
        Point secondPoint = new Point(30, 40);
        Point thirdPoint = new Point(50, 60);
        ColoredTriangle triangle = new ColoredTriangle(firstPoint, secondPoint, thirdPoint, 6);
        assertAll(
                () -> assertEquals(10, triangle.getFirstPoint().getX()),
                () -> assertEquals(20, triangle.getFirstPoint().getY()),
                () -> assertEquals(30, triangle.getSecondPoint().getX()),
                () -> assertEquals(40, triangle.getSecondPoint().getY()),
                () -> assertEquals(50, triangle.getThirdPoint().getX()),
                () -> assertEquals(60, triangle.getThirdPoint().getY()),
                () -> assertEquals(6, triangle.getColor())
        );
    }

    @Test
    public void testColoredTriangle2() {
        ColoredTriangle triangle = new ColoredTriangle(10, 20, 30, 40, 50 ,60, 6);
        assertAll(
                () -> assertEquals(10, triangle.getFirstPoint().getX()),
                () -> assertEquals(20, triangle.getFirstPoint().getY()),
                () -> assertEquals(30, triangle.getSecondPoint().getX()),
                () -> assertEquals(40, triangle.getSecondPoint().getY()),
                () -> assertEquals(50, triangle.getThirdPoint().getX()),
                () -> assertEquals(60, triangle.getThirdPoint().getY()),
                () -> assertEquals(6, triangle.getColor())
        );
    }

    @Test
    public void testColoredTriangle3() {
        ColoredTriangle triangle = new ColoredTriangle(20, 6);
        assertAll(
                () -> assertEquals(0, triangle.getFirstPoint().getX()),
                () -> assertEquals(0, triangle.getFirstPoint().getY()),
                () -> assertEquals(0, triangle.getSecondPoint().getX()),
                () -> assertEquals(-20, triangle.getSecondPoint().getY()),
                () -> assertEquals(20, triangle.getThirdPoint().getX()),
                () -> assertEquals(0, triangle.getThirdPoint().getY()),
                () -> assertEquals(6, triangle.getColor())
        );
    }

    @Test
    public void testColoredTriangle4() {
        ColoredTriangle triangle = new ColoredTriangle(6);
        assertAll(
                () -> assertEquals(0, triangle.getFirstPoint().getX()),
                () -> assertEquals(0, triangle.getFirstPoint().getY()),
                () -> assertEquals(0, triangle.getSecondPoint().getX()),
                () -> assertEquals(-1, triangle.getSecondPoint().getY()),
                () -> assertEquals(1, triangle.getThirdPoint().getX()),
                () -> assertEquals(0, triangle.getThirdPoint().getY()),
                () -> assertEquals(6, triangle.getColor())
        );
    }

    @Test
    public void testColoredTriangle5() {
        ColoredTriangle triangle = new ColoredTriangle();
        assertAll(
                () -> assertEquals(0, triangle.getFirstPoint().getX()),
                () -> assertEquals(0, triangle.getFirstPoint().getY()),
                () -> assertEquals(0, triangle.getSecondPoint().getX()),
                () -> assertEquals(-1, triangle.getSecondPoint().getY()),
                () -> assertEquals(1, triangle.getThirdPoint().getX()),
                () -> assertEquals(0, triangle.getThirdPoint().getY()),
                () -> assertEquals(1, triangle.getColor())
        );
    }

    @Test
    public void testSetCoordinatesAndColor() {
        ColoredTriangle triangle = new ColoredTriangle(10, 20, 30, 40, 50 ,60, 6);
        triangle.setFirstPoint(new Point(50, 60));
        triangle.setSecondPoint(new Point(100, 200));
        triangle.setThirdPoint(new Point(300, 400));
        triangle.setColor(20);
        assertAll(
                () -> assertEquals(50, triangle.getFirstPoint().getX()),
                () -> assertEquals(60, triangle.getFirstPoint().getY()),
                () -> assertEquals(100, triangle.getSecondPoint().getX()),
                () -> assertEquals(200, triangle.getSecondPoint().getY()),
                () -> assertEquals(300, triangle.getThirdPoint().getX()),
                () -> assertEquals(400, triangle.getThirdPoint().getY()),
                () -> assertEquals(20, triangle.getColor())
        );
    }

    @Test
    public void testMoveColoredTriangle() {
        ColoredTriangle triangle = new ColoredTriangle(10, 20, 30, 40, 50 ,60, 6);
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
    public void testEqualsColoredTriangle() {
        ColoredTriangle triangle1 = new ColoredTriangle(10, 20, 30, 40, 50 ,60, 6);
        ColoredTriangle triangle2 = new ColoredTriangle(10, 20, 20, 40, 100 ,60, 6);
        ColoredTriangle triangle3 = new ColoredTriangle(10, 20, 30, 40, 50 ,60, 6);
        assertEquals(triangle1, triangle3);
        assertNotEquals(triangle1, triangle2);
    }
}
