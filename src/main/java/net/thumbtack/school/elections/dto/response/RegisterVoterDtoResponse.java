package net.thumbtack.school.elections.dto.response;

import java.util.Objects;
import java.util.UUID;

public class RegisterVoterDtoResponse {
    private UUID token;

    public RegisterVoterDtoResponse() {
        this.token = UUID.randomUUID();
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterVoterDtoResponse that = (RegisterVoterDtoResponse) o;
        return Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }
}
