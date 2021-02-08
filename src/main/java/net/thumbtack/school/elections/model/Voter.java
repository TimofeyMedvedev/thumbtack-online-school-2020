package net.thumbtack.school.elections.model;

import net.thumbtack.school.elections.dto.request.RegisterVoterDtoRequest;

import java.util.Objects;

public class Voter {
    private String firstName;
    private String lastName;
    private String middleName;
    private String street;
    private int house;
    private int apartment;
    private String login;
    private String password;

    public Voter(RegisterVoterDtoRequest registerVoterDtoRequest) {
        this.firstName = registerVoterDtoRequest.getFirstName();
        this.lastName = registerVoterDtoRequest.getLastName();
        this.middleName = registerVoterDtoRequest.getMiddleName();
        this.street = registerVoterDtoRequest.getStreet();
        this.house = registerVoterDtoRequest.getHouse();
        this.apartment = registerVoterDtoRequest.getApartment();
        this.login = registerVoterDtoRequest.getLogin();
        this.password = registerVoterDtoRequest.getPassword();
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
        Voter voter = (Voter) o;
        return house == voter.house &&
                apartment == voter.apartment &&
                Objects.equals(firstName, voter.firstName) &&
                Objects.equals(lastName, voter.lastName) &&
                Objects.equals(middleName, voter.middleName) &&
                Objects.equals(street, voter.street) &&
                Objects.equals(login, voter.login) &&
                Objects.equals(password, voter.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName, street, house, apartment, login, password);
    }
}
