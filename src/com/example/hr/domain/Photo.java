package com.example.hr.domain;

import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

public final class Photo {
    private final byte[] value;

    public static Photo of(String base64Value) {
        return new Photo(Base64.getDecoder().decode(base64Value));
    }

    public static Photo of(byte[] value) {
        Objects.requireNonNull(value);
        if(value.length == 0){
            throw new IllegalArgumentException("Photo is empty");
        }
        return new Photo(value);
    }
    private Photo(byte[] value) {
        this.value = value;
    }

    public byte[] getValue() {
        return value;
    }
    public String getBase64Value() {
        return Base64.getEncoder().encodeToString(value);
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return Objects.deepEquals(value, photo.value);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(value);
    }
}
