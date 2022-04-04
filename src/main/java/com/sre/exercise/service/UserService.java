package com.sre.exercise.service;

import com.sre.exercise.entity.UserDTO;

import java.util.List;


public interface UserService {


    /**
     *
     * @param userDTO
     * @return
     */
    UserDTO createUser(final UserDTO userDTO);

    /**
     *
     * @param id
     * @return
     */
    UserDTO getUserById(final int id);
    List<UserDTO> getUsers();
    UserDTO updateUser(UserDTO userDTO);
    String deleteUserById(final int id);

}
