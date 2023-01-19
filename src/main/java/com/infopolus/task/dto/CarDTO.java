package com.infopolus.task.dto;

public class CarDTO {
    private int id;
    private int userId;
    private String userFullName;
    private String model;
    private int speed;

    public CarDTO() {
    }

    public CarDTO(int id, int userId, String userFullName, String model, int speed) {
        this.id = id;
        this.userId = userId;
        this.userFullName = userFullName;
        this.model = model;
        this.speed = speed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
