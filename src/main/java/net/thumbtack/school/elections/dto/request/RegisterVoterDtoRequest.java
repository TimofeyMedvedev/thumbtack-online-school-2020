package net.thumbtack.school.elections.dto.request;

import java.util.Objects;

public class RegisterVoterDtoRequest {
    private String firstName;
    private String lastName;
    private String middleName;
    private String street;
    private int house;
    private int apartment;
    private String login;
    private String password;

    public RegisterVoterDtoRequest(String firstName, String lastName, String middleName, String street,
                 int house, int apartment, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.login = login;
        this.password = password;
    }

    // REVU: создайте отдельный класс для валидации - Validator (можно поместить в пакет utils). сделайте
    // в нем публичные статичные методы для валидации разных объектов и вызывайте их после создания DtoRequest-класса
    public void validate() throws RegisterVoterDtoRequestException {
        if(firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty()) {
            throw new RegisterVoterDtoRequestException(RegisterVoterDtoRequestErrorCode.USER_WRONG_NAME);
        }

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterVoterDtoRequest that = (RegisterVoterDtoRequest) o;
        return house == that.house &&
                apartment == that.apartment &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(middleName, that.middleName) &&
                Objects.equals(street, that.street) &&
                Objects.equals(login, that.login) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName, street, house, apartment, login, password);
    }
}
