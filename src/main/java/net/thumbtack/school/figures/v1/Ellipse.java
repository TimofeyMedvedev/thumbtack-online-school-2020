package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Ellipse {
    private Point center;
    private int xAxis;
    private int yAxis;

    public Ellipse(Point center, int xAxis, int yAxis) {
        this.center = center;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse(int xCenter, int yCenter, int xAxis, int yAxis) {
        this(new Point(xCenter, yCenter), xAxis, yAxis);
    }

    public Ellipse(int xAxis, int yAxis) {
        this(new Point(0, 0), xAxis, yAxis);
    }

    public Ellipse() {
        this(new Point(0, 0), 1, 1);
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getXAxis() {
        return xAxis;
    }

    public void setXAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public int getYAxis() {
        return yAxis;
    }

    public void setYAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public void moveTo(int x, int y) {
        center.moveTo(x, y);
    }

    public void moveTo(Point point) {
        center = point;
    }

    public void moveRel(int dx, int dy) {
        center.moveTo(center.getX() + dx, center.getY() + dy);
    }

    public void resize(double ratio) {
        xAxis *= ratio;
        yAxis *= ratio;
    }

    public void stretch(double xRatio, double yRatio) {
        xAxis *= xRatio;
        yAxis *= yRatio;
    }

    public double getArea() {
        return Math.PI * xAxis / 2 * yAxis / 2;
    }

    public double getPerimeter() {
        return 2 * Math.PI * Math.sqrt((double) (xAxis * xAxis + yAxis * yAxis) / 8);
    }

    public boolean isInside(int x, int y) {
        int x0 = center.getX();
        int y0 = center.getY();
        double dist = (x - x0) * (x - x0) / ((double) (xAxis/2) * (double) (xAxis/2))
                + (y - y0) * (y - y0) / ((double) (yAxis/2) * (double) (yAxis/2));
        return dist <= 1;
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ellipse ellipse = (Ellipse) o;
        return xAxis == ellipse.xAxis &&
                yAxis == ellipse.yAxis &&
                center.equals(ellipse.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, xAxis, yAxis);
    }
}
