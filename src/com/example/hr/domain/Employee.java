package com.example.hr.domain;

import com.example.ddd.annotations.Aggregate;

//Ubiquitous language
@Aggregate(id="identity")
public class Employee {
    private final IdentityNo identity;
    private FullName fullName;
    private Iban iban;
    private Money salary;
    private JobStyle jobStyle;
    private Photo photo;
    private Department department;
    private final BirthYear birthYear;

    public Employee(IdentityNo identity, FullName fullName, BirthYear birthYear) {
        this.identity = identity;
        this.fullName = fullName;
        this.birthYear = birthYear;
    }

    public Employee(IdentityNo identity, BirthYear birthYear, Department department, Photo photo, JobStyle jobStyle, Money salary, Iban iban, FullName fullName) {
        this.identity = identity;
        this.birthYear = birthYear;
        this.department = department;
        this.photo = photo;
        this.jobStyle = jobStyle;
        this.salary = salary;
        this.iban = iban;
        this.fullName = fullName;
    }

    public Employee(Builder builder) {
        this.identity = builder.identity;
        this.fullName = builder.fullName;
        this.iban = builder.iban;
        this.salary = builder.salary;
        this.jobStyle = builder.jobStyle;
        this.photo = builder.photo;
        this.department = builder.department;
        this.birthYear = builder.birthYear;

    }

    public IdentityNo getIdentity() {
        return identity;
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public Iban getIban() {
        return iban;
    }

    public void setIban(Iban iban) {
        this.iban = iban;
    }

    public Money getSalary() {
        return salary;
    }

    public void setSalary(Money salary) {
        this.salary = salary;
    }

    public JobStyle getJobStyle() {
        return jobStyle;
    }

    public void setJobStyle(JobStyle jobStyle) {
        this.jobStyle = jobStyle;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public BirthYear getBirthYear() {
        return birthYear;
    }

    public static class Builder {
        private IdentityNo identity;
        private FullName fullName;
        private Iban iban;
        private Money salary;
        private JobStyle jobStyle;
        private Photo photo;
        private Department department;
        private BirthYear birthYear;


        public Builder(String value) {
            this.identity = IdentityNo.valueOf(value);
        }

        public Builder fullname(String firstname, String lastname) {
            this.fullName = FullName.of( firstname, lastname );
            return this;
        }
        public Builder iban(String iban) {
            this.iban = Iban.of( iban );
            return this;
        }
        public Builder salary(double value, FiatCurrency currency) {
            this.salary = Money.of(value, currency);
            return this;
        }
        public Builder salary(double value) {
            this.salary = Money.ofTurkishLiras(value);
            return this;
        }
        public Builder jobStyle(String value) {
            this.jobStyle = JobStyle.valueOf( value );
            return this;
        }
        public Builder department(String value) {
            this.department = Department.valueOf(value);
            return this;
        }
        public Builder department(Department department) {
            this.department = department;
            return this;
        }
        public Builder photo(byte[] value) {
            this.photo = Photo.of(value);
            return this;
        }
        public Builder photo(String value) {
            this.photo = Photo.of(value);
            return this;
        }
        public Builder birthYear(int year) {
            this.birthYear = BirthYear.valueOf(year);
            return this;
        }
        public Employee build() {
            //validation
            //business rul
            //constrait
            //invariance
            return new Employee(this);
        }
    }
}
