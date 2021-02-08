package net.thumbtack.school.colors.v3;

public enum Color {
    RED, GREEN, BLUE;

    public static Color colorFromString(String colorString) throws ColorException {
        if(colorString == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        try {
            return Color.valueOf(colorString);
        } catch (IllegalArgumentException exc) {
            throw new ColorException(ColorErrorCode.WRONG_COLOR_STRING);
        }
    }
}
