package com.infopolus.task.controllers;

import com.infopolus.task.dao.UserDAO;
import com.infopolus.task.dto.CarDTO;
import com.infopolus.task.models.Car;
import com.infopolus.task.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private UserDAO userDAO;

    @Autowired
    public CarController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping
    public String getCars(Model model) {
        int id = 0;
        List<CarDTO> carDTOList = new ArrayList<>();
        for (User user : userDAO.getUsers()) {
            if (!user.getCars().isEmpty()) {
                for (Car car : user.getCars()) {
                    CarDTO carDTO = new CarDTO(++id, user.getId(), user.getName() + " " + user.getSurname(),
                            car.getModel(), car.getSpeed());
                    carDTOList.add(carDTO);
                }
            }
        }
        model.addAttribute("carsDTO", carDTOList);

        return "cars/all_cars";
    }
}
