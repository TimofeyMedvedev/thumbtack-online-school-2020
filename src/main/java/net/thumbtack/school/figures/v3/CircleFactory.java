package net.thumbtack.school.figures.v3;

public class CircleFactory {
    private static int circleCount;

    public static Circle createCircle(Point center, int radius) {
        circleCount++;
        return new Circle(center, radius);
    }

    public static int getCircleCount() {
        return circleCount;
    }

    public static void reset() {
        circleCount = 0;
    }
}
