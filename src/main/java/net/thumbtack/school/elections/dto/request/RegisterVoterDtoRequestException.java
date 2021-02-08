// REVU: создайте отдельный пакет error для исключений и перечислений
package net.thumbtack.school.elections.dto.request;

public class RegisterVoterDtoRequestException extends Exception {
    private RegisterVoterDtoRequestErrorCode error;

    public RegisterVoterDtoRequestException(RegisterVoterDtoRequestErrorCode error) {
        this.error = error;
    }

    public RegisterVoterDtoRequestErrorCode getErrorCode() {
        return error;
    }
}
