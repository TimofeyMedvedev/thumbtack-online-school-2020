package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Square {
    private Point leftTop;
    private int size;

    public Square(Point leftTop, int size) {
        this.leftTop = leftTop;
        this.size = size;
    }

    public Square(int xLeft, int yTop, int size) {
        this(new Point(xLeft, yTop), size);
    }

    public Square(int size) {
        this(new Point(0, -size), size);
    }

    public Square() {
        this(new Point(0, -1), 1);
    }

    public Point getTopLeft() {
        return leftTop;
    }

    public void setTopLeft(Point leftTop) {
        this.leftTop = leftTop;
    }

    public Point getBottomRight() {
        return new Point(leftTop.getX() + size, leftTop.getY() + size);
    }

    public int getLength() {
        return size;
    }

    public void moveTo(int x, int y) {
        leftTop.moveTo(x, y);
    }

    public void moveTo(Point point) {
        leftTop = point;
    }

    public void moveRel(int dx, int dy) {
        leftTop.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        size *= ratio;
    }

    public double getArea() {
        return size * size;
    }

    public double getPerimeter() {
        return size * 4;
    }

    public boolean isInside(int x, int y) {
        return (x >= leftTop.getX() && x <= leftTop.getX() + size)
                && (y >= leftTop.getY() && y <= leftTop.getY() + size);
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isIntersects(Square square) {
        return square.leftTop.getY() <= leftTop.getY() + size && square.leftTop.getX() <= leftTop.getX() + size &&
                square.leftTop.getY() + size >= leftTop.getY() && square.leftTop.getX() + size >= leftTop.getX();
    }

    public boolean isInside(Square square) {
        Point left = square.getTopLeft();
        Point right = square.getBottomRight();
        int xLeft = left.getX();
        int yLeft = left.getY();
        int xRight = right.getX();
        int yRight = right.getY();
        return (xLeft >= leftTop.getX() && yLeft >= leftTop.getY())
                && (xRight <= leftTop.getX() + size && yRight <= leftTop.getY() + size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return size == square.size &&
                leftTop.equals(square.leftTop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftTop, size);
    }
}
