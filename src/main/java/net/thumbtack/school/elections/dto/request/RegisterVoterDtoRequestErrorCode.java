package net.thumbtack.school.elections.dto.request;

public enum  RegisterVoterDtoRequestErrorCode {
    USER_WRONG_NAME("Имя и фамилия не могут быть пустой строкой"),
    USER_WRONG_LASTNAME("Введите свою фамилию");

    private String errorString;

    private RegisterVoterDtoRequestErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
