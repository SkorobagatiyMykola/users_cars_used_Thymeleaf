package com.infopolus.task.dao;

import com.infopolus.task.models.Car;
import com.infopolus.task.models.User;
import com.infopolus.task.utils.GenerationDB;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserDAO {
    private static int USER_COUNT = GenerationDB.USER_COUNT;
    private GenerationDB generation = new GenerationDB();
    private List<User> users = generation.getUsers();

    public List<User> getUsers() {
        return users;
    }

    public User getUserById(int id) {
        return users.stream().filter(user -> user.getId() == id).
                findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++USER_COUNT);
        users.add(user);
    }

    public void saveCar(int userId, Car car) {
        User user = getUserById(userId);
        List<Car> cars = new ArrayList<>(user.getCars());
        cars.add(car);
        user.setCars(cars);
    }

    public void update(int id, User updateUser) {
        User userToBeUpdated = getUserById(id);
        userToBeUpdated.setName(updateUser.getName());
        userToBeUpdated.setSurname(updateUser.getSurname());
        userToBeUpdated.setAge(updateUser.getAge());
        userToBeUpdated.setEmail(updateUser.getEmail());
    }

    public void delete(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
