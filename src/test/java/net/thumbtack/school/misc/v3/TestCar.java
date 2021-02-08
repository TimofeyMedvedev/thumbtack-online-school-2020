package net.thumbtack.school.misc.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorErrorCode;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.figures.v3.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class TestCar {

    @Test
    public void testCar1() throws ColorException {
        Point location = new Point(43, 98);
        Car car = new Car("Mazda", "A123UY", Color.RED, location);
        assertAll(
                () -> assertEquals("Mazda", car.getModel()),
                () -> assertEquals("A123UY", car.getNumber()),
                () -> assertEquals(Color.RED, car.getColor()),
                () -> assertEquals(location, car.getLocation())
        );
    }

    @Test
    public void testCar2() throws ColorException {
        Point location = new Point(43, 98);
        Car car = new Car("Mazda", "A123UY", location);
        assertAll(
                () -> assertEquals("Mazda", car.getModel()),
                () -> assertEquals("A123UY", car.getNumber()),
                () -> assertEquals(Color.GREEN, car.getColor()),
                () -> assertEquals(location, car.getLocation())
        );
    }

    @Test
    public void testCar3() throws ColorException {
        Point location = new Point(43, 98);
        Car car = new Car(location);
        assertAll(
                () -> assertNull(car.getModel()),
                () -> assertNull(car.getNumber()),
                () -> assertEquals(Color.GREEN, car.getColor()),
                () -> assertEquals(location, car.getLocation())
        );
    }

    @Test
    public void testCar4() throws ColorException {
        Point location = new Point(43, 98);
        Car car = new Car("Mazda", "A123UY", "BLUE", location);
        assertAll(
                () -> assertEquals("Mazda", car.getModel()),
                () -> assertEquals("A123UY", car.getNumber()),
                () -> assertEquals(Color.BLUE, car.getColor()),
                () -> assertEquals(location, car.getLocation())
        );
    }

    @Test
    public void testCar5() throws ColorException {
        Point location = new Point(43, 98);
        assertThrows(ColorException.class, () -> new Car("Mazda", "A123UY", (Color) null, location));
    }

    @Test
    public void testCar6() throws ColorException {
        Point location = new Point(43, 98);
        assertThrows(ColorException.class, () -> new Car("Mazda", "A123UY", (String) null, location));
    }

    @Test
    public void testSetColor1() throws ColorException {
        Point location = new Point(43, 98);
        Car car = new Car("Mazda", "A123UY", Color.GREEN, location);
        assertAll(
                () -> assertEquals("Mazda", car.getModel()),
                () -> assertEquals("A123UY", car.getNumber()),
                () -> assertEquals(Color.GREEN, car.getColor()),
                () -> assertEquals(location, car.getLocation())
        );
        car.setColor(Color.BLUE);
        assertEquals(Color.BLUE, car.getColor());
    }

    @Test
    public void testSetColor2() throws ColorException {
        Point location = new Point(43, 98);
        Car car = new Car("Mazda", "A123UY", "GREEN", location);
        assertAll(
                () -> assertEquals("Mazda", car.getModel()),
                () -> assertEquals("A123UY", car.getNumber()),
                () -> assertEquals(Color.GREEN, car.getColor()),
                () -> assertEquals(location, car.getLocation())
        );
        car.setColor("BLUE");
        assertEquals(Color.BLUE, car.getColor());
    }

    @Test
    public void testSetColor3() throws ColorException {
        Point location = new Point(43, 98);
        Car car = new Car("Mazda", "A123UY", "GREEN", location);
        assertAll(
                () -> assertEquals("Mazda", car.getModel()),
                () -> assertEquals("A123UY", car.getNumber()),
                () -> assertEquals(Color.GREEN, car.getColor()),
                () -> assertEquals(location, car.getLocation())
        );
        assertThrows(ColorException.class, () -> car.setColor((Color) null));
    }

    @Test
    public void testSetColor4() throws ColorException {
        Point location = new Point(43, 98);
        Car car = new Car("Mazda", "A123UY", "GREEN", location);
        assertAll(
                () -> assertEquals("Mazda", car.getModel()),
                () -> assertEquals("A123UY", car.getNumber()),
                () -> assertEquals(Color.GREEN, car.getColor()),
                () -> assertEquals(location, car.getLocation())
        );
        assertThrows(ColorException.class, () -> car.setColor((String) null));
    }

    @Test
    @SuppressWarnings("unused")
    public void testSetWrongColor() {
        try {
            Car car = new Car("Mazda", "A123UY", "YELLOW", new Point(43, 98));
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.WRONG_COLOR_STRING, ex.getErrorCode());
        }
        try {
            Car car = new Car("Mazda", "A123UY", (String) null, new Point(43, 98));
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            Car car = new Car("Mazda", "A123UY", (Color) null, new Point(43, 98));
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            Car car = new Car("Mazda", "A123UY", "GREEN", new Point(43, 98));
            car.setColor((Color) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            Car car = new Car("Mazda", "A123UY", "GREEN", new Point(43, 98));
            car.setColor("yellow");
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.WRONG_COLOR_STRING, ex.getErrorCode());
        }
        try {
            Car car = new Car("Mazda", "A123UY", "GREEN", new Point(43, 98));
            car.setColor((String) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
    }

    @Test
    public void testSetFields() throws ColorException {
        Point location = new Point(43, 98);
        Car car = new Car("Mazda", "A123UY", location);
        car.setColor(Color.BLUE);
        car.setModel("Toyota");
        car.setNumber("W987FE");
        Point newLocation = new Point(5, 918);
        car.setLocation(newLocation);
        assertAll(
                () -> assertEquals("Toyota", car.getModel()),
                () -> assertEquals("W987FE", car.getNumber()),
                () -> assertEquals(Color.BLUE, car.getColor()),
                () -> assertEquals(newLocation, car.getLocation())
        );
    }

    @Test
    public void testMoveTo1() throws ColorException {
        Point location = new Point(43, 98);
        Car car = new Car("Mazda", "A123UY", location);
        car.moveTo(88, 14);
        Point newLocation = car.getLocation();
        assertAll(
                () -> assertEquals(88, newLocation.getX()),
                () -> assertEquals(14, newLocation.getY())
        );
    }

    @Test
    public void testMoveTo2() throws ColorException {
        Point location = new Point(43, 98);
        Car car = new Car("Mazda", "A123UY", location);
        Point newLocation = new Point(88, 14);
        car.moveTo(newLocation);
        assertAll(
                () -> assertEquals(88, car.getLocation().getX()),
                () -> assertEquals(14, car.getLocation().getY()),
                () -> assertEquals(newLocation, car.getLocation())
        );
    }

    @Test
    public void testMoveRel() throws ColorException {
        Point location = new Point(40, 90);
        Car car = new Car("Mazda", "A123UY", location);
        car.moveRel(20, 10);
        assertAll(
                () -> assertEquals(60, car.getLocation().getX()),
                () -> assertEquals(100, car.getLocation().getY())
        );
    }

    @Test
    public void testEqualsCar() throws ColorException {
        Car car1 = new Car("Mazda", "A123UY", "GREEN", new Point(43, 98));
        Car car2 = new Car("Mazda", "A123UY", "RED", new Point(43, 98));
        Car car3 = new Car("Mazda", "A123UY", "GREEN", new Point(43, 98));
        Assertions.assertEquals(car1, car3);
        assertNotEquals(car1, car2);
    }
}
