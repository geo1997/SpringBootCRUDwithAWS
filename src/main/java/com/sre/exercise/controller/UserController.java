package com.sre.exercise.controller;

import com.sre.exercise.entity.UserData;
import com.sre.exercise.entity.UserEntity;
import com.sre.exercise.exception.UserAlreadyExistException;
import com.sre.exercise.exception.UserDoesNotExist;
import com.sre.exercise.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/add")
    public String addUser(@RequestBody final @Valid UserData userData){
        try {
            userService.createUser(userData);
        }catch (UserAlreadyExistException e){
            return "An account already exists for this email.";
        }
        return "Registration Successful";
    }


    @GetMapping("/user/{id}")
    public UserEntity getUserById(@PathVariable final long id) throws UserDoesNotExist{
            return userService.getUserById(id);
    }

    @GetMapping("/users")
    public List<UserEntity> getAllUsers(){
        return userService.getUsers();
    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestBody final UserData userData){
        try {
            userService.updateUser(userData);
        }catch (UserDoesNotExist e){
            return "User Does not Exist.";
        }
        return "Update Successful";
    }


    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable final long id){

        try{
            return  userService.deleteUserById(id);
        }catch (UserDoesNotExist e){
            return "User Does not Exist.";
        }
    }
}
