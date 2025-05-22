package com.example.hr.domain;

import java.util.Objects;

public record Iban(String value) {
    public static Iban of(String value) {
        Objects.requireNonNull(value);
        if (!isValid(value)){
            throw new IllegalArgumentException("Invalid IBAN");
        }
        return new Iban(value);
    }

    public static boolean isValid(String value){
        return true;
    }
}
