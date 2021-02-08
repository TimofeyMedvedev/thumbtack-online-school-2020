package net.thumbtack.school.colors.v3;

public enum ColorErrorCode {
    WRONG_COLOR_STRING("This color is not in the palette"),
    NULL_COLOR("You cannot pass null as a parameter");

    private String errorString;

    private ColorErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
