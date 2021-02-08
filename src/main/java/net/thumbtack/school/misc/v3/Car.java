package net.thumbtack.school.misc.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorErrorCode;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.figures.v3.Point;
import net.thumbtack.school.iface.v3.Colored;
import net.thumbtack.school.iface.v3.Movable;

import java.util.Objects;

public class Car implements Colored, Movable {
    private String model;
    private String number;
    private Color color;
    private Point location;

    public Car(String model, String number, Color color, Point location) throws ColorException {
        setColor(color);
        this.model = model;
        this.number = number;
        this.location = location;
    }

    public Car(String model, String number, String color, Point location) throws ColorException {
        this(model, number, Color.colorFromString(color), location);
    }

    public Car(String model, String number, Point location) throws ColorException {
        this(model, number, Color.GREEN, location);
    }

    public Car(Point location) throws ColorException {
        this(null, null, Color.GREEN, location);
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
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) throws ColorException {
        if(color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
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
