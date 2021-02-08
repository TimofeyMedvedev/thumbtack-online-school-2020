package net.thumbtack.school.iface.v3;

import net.thumbtack.school.figures.v3.Point;

public interface Movable {
    void moveTo(int x, int y);

    default void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    void moveRel(int dx, int dy);
}
