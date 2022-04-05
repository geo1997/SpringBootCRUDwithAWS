package com.sre.exercise.service;

import com.sre.exercise.entity.UserData;
import com.sre.exercise.entity.UserEntity;
import com.sre.exercise.exception.UserAlreadyExistException;
import com.sre.exercise.exception.UserDoesNotExist;

import java.util.List;


public interface UserService {



    void createUser(final UserData userData) throws UserAlreadyExistException;
    UserEntity getUserById(final long id) throws UserDoesNotExist;
    List<UserEntity> getUsers();
    void updateUser(final UserData userData) throws UserDoesNotExist;
    String deleteUserById(final long id) throws UserDoesNotExist;
    boolean checkIfUserExist(final String email);
    boolean userExist(final Long id);


}
