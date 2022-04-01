package com.sre.exercise.service;

import com.sre.exercise.entity.User;
import com.sre.exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User userToBeUpdated = userRepository.findById(user.getId()).orElse(null);
        userToBeUpdated.setFullName(user.getFullName());
        userToBeUpdated.setAddress(user.getAddress());
        userToBeUpdated.setEmail(user.getEmail());
        userToBeUpdated.setPhoneNumber(user.getPhoneNumber());
        userToBeUpdated.setNic(user.getNic());
        return userRepository.save(userToBeUpdated);
    }

    @Override
    public String deleteUserById(int id) {
        User userToBeDeleted = userRepository.findById(id).orElse(null);
        return "User deleted successfully ";
    }
}
