package net.thumbtack.school.boxes.v3;

import net.thumbtack.school.figures.v3.Figure;
import net.thumbtack.school.iface.v3.HasArea;

public class PairBox<T extends Figure, V extends Figure> implements HasArea {
    private static final double EPS = 1E-6;
    private T contentFirst;
    private V contentSecond;

    public PairBox(T contentFirst, V contentSecond) {
        this.contentFirst = contentFirst;
        this.contentSecond = contentSecond;
    }

    public T getContentFirst() {
        return contentFirst;
    }

    public void setContentFirst(T contentFirst) {
        this.contentFirst = contentFirst;
    }

    public V getContentSecond() {
        return contentSecond;
    }

    public void setContentSecond(V contentSecond) {
        this.contentSecond = contentSecond;
    }

    @Override
    public double getArea() {
        return contentFirst.getArea() + contentSecond.getArea();
    }

    public boolean isAreaEqual(PairBox another) {
        return Math.abs(getArea() - another.getArea()) < EPS;
    }

    public static boolean isAreaEqual(PairBox pairBox, PairBox anotherPairBox) {
        return pairBox.isAreaEqual(anotherPairBox);
    }
}
