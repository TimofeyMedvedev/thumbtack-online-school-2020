package net.thumbtack.school.elections.database;

public enum DatabaseErrorCode {
    VOTER_WRONG_LOGIN("Пользователь с таким логином существует"),
    VOTER_WRONG("Пользователь с такими параметрами уже зарегестрирован на сервере");

    private String errorString;

    private DatabaseErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
