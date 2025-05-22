package com.example.hr.domain;

import com.example.ddd.annotations.ValueObject;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@ValueObject
public final class IdentityNo {
    private final String value;
    private static final Map<String,IdentityNo> cache = new ConcurrentHashMap<>();

    static public IdentityNo valueOf(String value) {
        //validation
        Objects.requireNonNull(value);
        if(!isValid(value)){
            throw new IllegalArgumentException("this is not a valid identity number");
        }
        //object pooling
        var cachedIdentity = cache.get(value);
        if(Objects.isNull(cachedIdentity)){
            cachedIdentity = new IdentityNo(value);
            cache.put(value, cachedIdentity);
        }
        return cachedIdentity;
    }
    private static boolean isValid(String value) {
        return true;
    }
    private IdentityNo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        IdentityNo that = (IdentityNo) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "IdentityNo{" +
                "value='" + value + '\'' +
                '}';
    }
}
