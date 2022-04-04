package com.sre.exercise.controller;

import com.sre.exercise.entity.UserDTO;
import com.sre.exercise.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/add")
    public UserDTO addUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }


    @GetMapping("/user/{id}")
    public UserDTO getUserById(@PathVariable final int id){
        return userService.getUserById(id);
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers(){
        return userService.getUsers();
    }

    @PutMapping("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }


    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable final int id){
        return userService.deleteUserById(id);
    }
}
