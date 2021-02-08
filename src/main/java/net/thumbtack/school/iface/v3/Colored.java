package net.thumbtack.school.iface.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorException;

public interface Colored {
    void setColor(Color color) throws ColorException;

    Color getColor();

    default void setColor(String colorString) throws ColorException {
        setColor(Color.colorFromString(colorString));
    }
}
