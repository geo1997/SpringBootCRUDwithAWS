package com.sre.exercise.service;

import com.sre.exercise.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {


    /**
     *
     * @param user
     * @return
     */
    User createUser(final User user);

    /**
     *
     * @param id
     * @return
     */
    User getUserById(final int id);
    List<User> getUsers();
    User updateUser(User user);
    String deleteUserById(final int id);

}
