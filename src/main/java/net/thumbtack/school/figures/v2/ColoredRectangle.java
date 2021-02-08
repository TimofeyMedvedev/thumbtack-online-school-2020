package net.thumbtack.school.figures.v2;

import net.thumbtack.school.iface.v2.Colored;

import java.util.Objects;

public class ColoredRectangle extends Rectangle implements Colored {
    private int color;

    public ColoredRectangle(Point leftTop, Point rightBottom, int color) {
        this(leftTop.getX(), leftTop.getY(), rightBottom.getX(), rightBottom.getY(), color);
    }

    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, int color) {
        super(xLeft, yTop, xRight, yBottom);
        this.color = color;
    }

    public ColoredRectangle(int length, int width, int color) {
        this(0, - width, length, 0, color);
    }

    public ColoredRectangle(int color) {
        this(1, 1, color);
    }

    public ColoredRectangle() {
        this(1,1,1);
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ColoredRectangle that = (ColoredRectangle) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}
