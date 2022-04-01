package com.sre.exercise.controller;

import com.sre.exercise.entity.User;
import com.sre.exercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/add")
    public User addUser(@RequestBody User user){
        return userService.createUser(user);
    }


    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable final int id){
        return userService.getUserById(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }


    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable final int id){
        return userService.deleteUserById(id);
    }
}
