package net.thumbtack.school.figures.v3;

import net.thumbtack.school.iface.v3.Stretchable;

import java.util.Objects;

public class Rectangle extends Figure implements Stretchable {
    private Point leftTop;
    private Point rightBottom;

    public Rectangle(Point leftTop, Point rightBottom) {
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {
        this(new Point(xLeft, yTop), new Point(xRight, yBottom));
    }

    public Rectangle(int length, int width) {
        this(new Point(0, - width), new Point(length, 0));
    }

    public Rectangle() {
        this(new Point(0, -1), new Point(1, 0));
    }

    public Point getTopLeft() {
        return leftTop;
    }

    public Point getBottomRight() {
        return rightBottom;
    }

    public void setTopLeft(Point leftTop) {
        this.leftTop = leftTop;
    }

    public void setBottomRight(Point rightBottom) {
        this.rightBottom = rightBottom;
    }

    public int getLength() {
        return rightBottom.getX() - leftTop.getX();
    }

    public int getWidth() {
        return rightBottom.getY() - leftTop.getY();
    }

    public void moveTo(int x, int y) {
        int length = getLength();
        int width = getWidth();
        leftTop.moveTo(x, y);
        rightBottom.moveTo(x + length, y + width);
    }

    public void moveRel(int dx, int dy) {
        leftTop.moveRel(dx, dy);
        rightBottom.moveRel(dx, dy);
    }

    @Override
    public void resize(double ratio) {
        int length = (int) (getLength() * ratio);
        int width = (int) (getWidth() * ratio);
        rightBottom.moveTo(leftTop.getX() + length, leftTop.getY() + width);
    }

    @Override
    public void stretch(double xRatio, double yRatio) {
        int length = (int) (getLength() * xRatio);
        int width = (int) (getWidth() * yRatio);
        rightBottom.moveTo(leftTop.getX() + length, leftTop.getY() + width);
    }

    @Override
    public double getArea() {
        return getLength() * getWidth();
    }

    public double getPerimeter() {
        return getLength() * 2 + getWidth() * 2;
    }

    @Override
    public boolean isInside(int x, int y) {
        return (x >= leftTop.getX() && x <= rightBottom.getX())
                && (y >= leftTop.getY() && y <= rightBottom.getY());
    }

    public boolean isIntersects(Rectangle rectangle) {
        return rectangle.leftTop.getY() <= rightBottom.getY() && rectangle.leftTop.getX() <= rightBottom.getX() &&
                rectangle.rightBottom.getY() >= leftTop.getY() && rectangle.rightBottom.getX() >= leftTop.getX();
    }

    public boolean isInside(Rectangle rectangle) {
        Point left = rectangle.getTopLeft();
        Point right = rectangle.getBottomRight();
        int xLeft = left.getX();
        int yLeft = left.getY();
        int xRight = right.getX();
        int yRight = right.getY();
        return (xLeft >= leftTop.getX() && yLeft >= leftTop.getY())
                && (xRight <= rightBottom.getX() && yRight <= rightBottom.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return leftTop.equals(rectangle.leftTop) &&
                rightBottom.equals(rectangle.rightBottom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftTop, rightBottom);
    }
}
