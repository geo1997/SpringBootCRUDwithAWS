package com.sre.exercise.service;


import com.sre.exercise.entity.UserDTO;
import com.sre.exercise.repository.UserRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        if (userDTO == null ) {
            throw new ResourceNotFoundException("Empty User");
        } else {
            return  userRepository.save(userDTO);
        }

    }

    @Override
    public UserDTO getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        UserDTO userDTOToBeUpdated = userRepository.findById(userDTO.getId()).orElse(null);
        userDTOToBeUpdated.setFullName(userDTO.getFullName());
        userDTOToBeUpdated.setAddress(userDTO.getAddress());
        userDTOToBeUpdated.setEmail(userDTO.getEmail());
        userDTOToBeUpdated.setPhoneNumber(userDTO.getPhoneNumber());
        userDTOToBeUpdated.setNic(userDTO.getNic());
        return userRepository.save(userDTOToBeUpdated);
    }

    @Override
    public String deleteUserById(int id) {
        UserDTO userDTOToBeDeleted = userRepository.findById(id).orElse(null);
        userRepository.delete(userDTOToBeDeleted);
        return "User deleted successfully ";
    }


}
