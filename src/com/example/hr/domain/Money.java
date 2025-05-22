package com.example.hr.domain;

import java.util.Objects;

// ValueObject
public class Money {

    private final double value;
    private final FiatCurrency currency;

    public static Money ofTurkishLiras(double value) {
        return of(value, FiatCurrency.TL);
    }

    public static Money of(double value, FiatCurrency currency) {
        Objects.requireNonNull(currency);
        if(value <= 0) {
            throw new IllegalArgumentException("Value must be greater than zero");
        }

        return new Money(value, currency);
    }
    private Money(double value, FiatCurrency currency) {
        this.value = value;
        this.currency = currency;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Double.compare(value, money.value) == 0 && currency == money.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                ", currency=" + currency +
                '}';
    }

    public Money multiply(double rate) {
        return Money.of(value * rate, currency);
    }
}
