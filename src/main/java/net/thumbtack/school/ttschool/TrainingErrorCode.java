package net.thumbtack.school.ttschool;

public enum TrainingErrorCode {
    TRAINEE_WRONG_FIRSTNAME("Name cannot be empty string or null"),
    TRAINEE_WRONG_LASTNAME("Last name cannot be empty string or null"),
    TRAINEE_WRONG_RATING("The score should be in the range from 1 to 5"),
    DUPLICATE_TRAINEE("Trainee is in the collection"),
    EMPTY_TRAINEE_QUEUE("The queue is empty"),
    GROUP_WRONG_NAME("Group name cannot be empty string or null"),
    GROUP_WRONG_ROOM("Room cannot be empty string or null"),
    TRAINEE_NOT_FOUND("Trainee not found"),
    SCHOOL_WRONG_NAME("School name cannot be empty string or null"),
    DUPLICATE_GROUP_NAME("Group with the same name already exists"),
    GROUP_NOT_FOUND("Group not found");


    private String errorString;

    private TrainingErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
