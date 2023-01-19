package com.infopolus.task.utils;

import com.infopolus.task.models.Car;
import com.infopolus.task.models.User;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println("Test ");

        GenerationDB generation = new GenerationDB();

        List<User> users= generation.getUsers();
        List<Car> cars= generation.getCars();

        System.out.println("=================");
    }
}
