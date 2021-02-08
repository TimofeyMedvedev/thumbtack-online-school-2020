package net.thumbtack.school.colors.v3;

public class ColorException extends Exception {
    private ColorErrorCode error;

    public ColorException(ColorErrorCode error) {
        this.error = error;
    }

    public ColorErrorCode getErrorCode() {
        return error;
    }
}
