package com.infopolus.task.models;

import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;


public class User {
    private int id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 3, max = 30, message = "Name should be between 3 and 30 characters")
    private String name;
    @NotEmpty(message = "Surname should not be empty")
    @Size(min = 3, max = 30, message = "Surname should be between 3 and 30 characters")
    private String surname;
    @Min(value = 1, message = "Age should be greater than 1")
    @Max(value = 125, message = "Age should be less than 125")
    private int age;
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    private List<Car> cars = new ArrayList<>();

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public static class Builder {
        private User newUser;

        public Builder() {
            newUser = new User();
        }

        public Builder withId(int id) {
            newUser.setId(id);
            return this;
        }

        public Builder withName(String name) {
            newUser.setName(name);
            return this;
        }

        public Builder withSurname(String surname) {
            newUser.setSurname(surname);
            return this;
        }

        public Builder withAge(int age) {
            newUser.setAge(age);
            return this;
        }

        public Builder withEmail(String email) {
            newUser.setEmail(email);
            return this;
        }

        public Builder withCars(List<Car> cars) {
            newUser.setCars(cars);
            return this;
        }

        public User build() {
            return newUser;
        }
    }
}
