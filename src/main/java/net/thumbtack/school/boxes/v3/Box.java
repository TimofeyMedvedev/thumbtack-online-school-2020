package net.thumbtack.school.boxes.v3;

import net.thumbtack.school.figures.v3.Figure;
import net.thumbtack.school.iface.v3.HasArea;

public class Box<T extends Figure> implements HasArea {
    private static final double EPS = 1E-6;
    private T content;

    public Box(T content) {
        super();
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public double getArea() {
        return content.getArea();
    }

    public boolean isAreaEqual(Box another) {
        return Math.abs(getArea() - another.getArea()) < EPS;
    }

    public static boolean isAreaEqual(Box box, Box anotherBox) {
        return box.isAreaEqual(anotherBox);
    }
}
