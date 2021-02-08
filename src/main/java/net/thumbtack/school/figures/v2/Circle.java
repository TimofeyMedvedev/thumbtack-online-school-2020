package net.thumbtack.school.figures.v2;

import net.thumbtack.school.iface.v2.Resizable;

import java.util.Objects;

public class Circle extends Figure implements Resizable {
    private Point center;
    private int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public Circle(int xCenter, int yCenter, int radius) {
        this(new Point(xCenter, yCenter), radius);
    }

    public Circle(int radius) {
        this(new Point(0, 0), radius);
    }

    public Circle() {
        this(new Point(0, 0), 1);
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void moveTo(int x, int y) {
        center.moveTo(x, y);
    }

    public void moveRel(int dx, int dy) {
        center.moveTo(center.getX() + dx, center.getY() + dy);
    }

    @Override
    public void resize(double ratio) {
        radius *= ratio;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean isInside(int x, int y) {
        int x1 = center.getX();
        int y1 = center.getY();
        double dist = Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));
        return dist <= radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius &&
                Objects.equals(center, circle.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }
}
