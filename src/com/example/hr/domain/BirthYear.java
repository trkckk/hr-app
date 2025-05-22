package com.example.hr.domain;

import java.util.Objects;

public final class BirthYear {
    private int value;

    public static BirthYear valueOf(int value) {
        if(value>2022){
            throw new IllegalArgumentException("This is not a valid birth year");
        }
        return new BirthYear(value);
    }

    private BirthYear(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BirthYear birthYear = (BirthYear) o;
        return value == birthYear.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "BirthYear{" +
                "value=" + value +
                '}';
    }
}
