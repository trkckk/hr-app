package com.example.hr.domain;

import java.util.Objects;

public class FullName {
    private final String firstName;
    private final String lastName;

    public static FullName of(String firstName, String lastName) {
        Objects.requireNonNull(firstName, "firstName cannot be null");
        Objects.requireNonNull(lastName, "lastName cannot be null");
        if(!firstName.matches("^[a-z]{3,}$")){
            throw new IllegalArgumentException("firstName must have at least 3 characters");
        }
        if(!lastName.matches("^[a-z]{2,}$")){
            throw new IllegalArgumentException("lastName must have at least 2 characters");
        }
        return new FullName(firstName, lastName);
    }

    private FullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FullName fullName = (FullName) o;
        return Objects.equals(firstName, fullName.firstName) && Objects.equals(lastName, fullName.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "FullName{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
