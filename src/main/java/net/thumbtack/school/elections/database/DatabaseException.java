package net.thumbtack.school.elections.database;

public class DatabaseException extends Exception {
    private DatabaseErrorCode error;

    public DatabaseException(DatabaseErrorCode error) {
        this.error = error;
    }

    public DatabaseErrorCode getErrorCode() {
        return error;
    }
}
