package net.thumbtack.school.misc.v2;

import net.thumbtack.school.figures.v2.Point;
import net.thumbtack.school.iface.v2.Colored;
import net.thumbtack.school.iface.v2.Movable;

import java.util.Objects;

public class Car implements Colored, Movable {
    private String model;
    private String number;
    private int color;
    private Point location;

    public Car(String model, String number, int color, Point location) {
        this.model = model;
        this.number = number;
        this.color = color;
        this.location = location;
    }

    public Car(String model, String number, Point location) {
        this(model, number, 0, location);
    }

    public Car(Point location) {
        this(null, null, 0, location);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    @Override
    public void moveTo(int x, int y) {
        location.moveTo(x, y);
        System.out.printf("Переместили машину в координаты: x = %d, y = %d", x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        location.moveRel(dx, dy);
        System.out.printf("Переместили машину в координаты: x = %d, y = %d", location.getX(), location.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return color == car.color &&
                model.equals(car.model) &&
                number.equals(car.number) &&
                location.equals(car.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, number, color, location);
    }
}
