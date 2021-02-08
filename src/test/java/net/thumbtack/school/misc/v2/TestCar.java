package net.thumbtack.school.misc.v2;

import net.thumbtack.school.figures.v2.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCar {

    @Test
    public void testCar1() {
        Point location = new Point(43, 98);
        Car car = new Car("Mazda", "A123UY", 3, location);
        assertAll(
                () -> assertEquals("Mazda", car.getModel()),
                () -> assertEquals("A123UY", car.getNumber()),
                () -> assertEquals(3, car.getColor()),
                () -> assertEquals(location, car.getLocation())
        );
    }

    @Test
    public void testCar2() {
        Point location = new Point(43, 98);
        Car car = new Car("Mazda", "A123UY", location);
        assertAll(
                () -> assertEquals("Mazda", car.getModel()),
                () -> assertEquals("A123UY", car.getNumber()),
                () -> assertEquals(0, car.getColor()),
                () -> assertEquals(location, car.getLocation())
        );
    }

    @Test
    public void testCar3() {
        Point location = new Point(43, 98);
        Car car = new Car(location);
        assertAll(
                () -> assertNull(car.getModel()),
                () -> assertNull(car.getNumber()),
                () -> assertEquals(0, car.getColor()),
                () -> assertEquals(location, car.getLocation())
        );
    }

    @Test
    public void testSetFields() {
        Point location = new Point(43, 98);
        Car car = new Car("Mazda", "A123UY", location);
        car.setColor(13);
        car.setModel("Toyota");
        car.setNumber("W987FE");
        Point newLocation = new Point(5, 918);
        car.setLocation(newLocation);
        assertAll(
                () -> assertEquals("Toyota", car.getModel()),
                () -> assertEquals("W987FE", car.getNumber()),
                () -> assertEquals(13, car.getColor()),
                () -> assertEquals(newLocation, car.getLocation())
        );
    }

    @Test
    public void testMoveTo1() {
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
    public void testMoveTo2() {
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
    public void testMoveRel() {
        Point location = new Point(40, 90);
        Car car = new Car("Mazda", "A123UY", location);
        car.moveRel(20, 10);
        assertAll(
                () -> assertEquals(60, car.getLocation().getX()),
                () -> assertEquals(100, car.getLocation().getY())
        );
    }
}
