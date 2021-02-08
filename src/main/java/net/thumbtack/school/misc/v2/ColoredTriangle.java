package net.thumbtack.school.misc.v2;

import net.thumbtack.school.figures.v2.Point;
import net.thumbtack.school.iface.v2.Colored;
import net.thumbtack.school.iface.v2.Movable;

import java.util.Objects;

public class ColoredTriangle implements Colored, Movable {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private int color;

    public ColoredTriangle(Point firstPoint, Point secondPoint, Point thirdPoint, int color) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        this.color = color;
    }

    public ColoredTriangle(int xOne, int yOne, int xTwo, int yTwo, int xThree, int yThree, int color) {
        this(new Point(xOne, yOne), new Point(xTwo, yTwo), new Point(xThree, yThree), color);
    }

    public ColoredTriangle(int leg, int color) {
        this(new Point(0, 0), new Point(0 , - leg), new Point(leg, 0), color);
    }

    public ColoredTriangle(int color) {
        this(new Point(0, 0), new Point(0, - 1), new Point(1, 0), color);
    }

    public ColoredTriangle() {
        this(new Point(0, 0), new Point(0, - 1), new Point(1, 0), 1);
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    public void setThirdPoint(Point thirdPoint) {
        this.thirdPoint = thirdPoint;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void moveTo(int x, int y) {
        secondPoint.moveTo((secondPoint.getX() - firstPoint.getX()) + x,(secondPoint.getY() - firstPoint.getY()) + y);
        thirdPoint.moveTo((thirdPoint.getX() - firstPoint.getX()) + x,(thirdPoint.getY() - firstPoint.getY()) + y);
        firstPoint.moveTo(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        firstPoint.moveRel(dx, dy);
        secondPoint.moveRel(dx, dy);
        thirdPoint.moveRel(dx, dy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColoredTriangle that = (ColoredTriangle) o;
        return color == that.color &&
                firstPoint.equals(that.firstPoint) &&
                secondPoint.equals(that.secondPoint) &&
                thirdPoint.equals(that.thirdPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstPoint, secondPoint, thirdPoint, color);
    }
}
