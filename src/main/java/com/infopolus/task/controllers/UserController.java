package com.infopolus.task.controllers;

import com.infopolus.task.dao.UserDAO;
import com.infopolus.task.models.Car;
import com.infopolus.task.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
@ControllerAdvice
@RequestMapping("/users")
public class UserController {

    private UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userDAO.getUsers());

        return "users/all_users";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDAO.getUserById(id));

        return "users/simple_user";
    }

    @GetMapping("/new")
    public String create(@ModelAttribute("user") User user) {

        return "users/new_user";
    }

    @PostMapping
    public String add(@ModelAttribute("user") @Validated User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "users/new_user";

        userDAO.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDAO.getUserById(id));
        return "users/edit_user";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Validated User user, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "users/edit_user";

        userDAO.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userDAO.delete(id);
        return "redirect:/users";
    }

    @PatchMapping("/{id}/new_car")
    public String addCar(@ModelAttribute("car") Car car, @PathVariable("id") int id) {
        userDAO.saveCar(id, car);

        //return "redirect:/users/simple_user";
        return "redirect:/cars";
    }
}
