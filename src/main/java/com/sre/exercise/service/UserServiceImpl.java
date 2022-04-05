package com.sre.exercise.service;


import com.sre.exercise.entity.UserData;
import com.sre.exercise.entity.UserEntity;
import com.sre.exercise.exception.UserAlreadyExistException;
import com.sre.exercise.exception.UserDoesNotExist;
import com.sre.exercise.repository.UserRepository;
import org.apache.catalina.User;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service("userService")
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserData user) throws UserAlreadyExistException {

        if (checkIfUserExist(user.getEmail())) {
            throw new UserAlreadyExistException("User already exists for this email");
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        encodePassword(userEntity, user);
        userRepository.save(userEntity);

    }


    @Override
    public UserEntity getUserById(long id) throws UserDoesNotExist {

        if(!userExist(id)){
            throw new UserDoesNotExist("User Does Not Exist");

        }
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        UserEntity userEntity = optionalUserEntity.get();
        return userEntity;


    }

    @Override
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(UserData user) throws UserDoesNotExist {

        if (!checkIfUserExist(user.getEmail())) {
            throw new UserDoesNotExist("User Does Not Exist");
        }
        UserEntity users = userRepository.findByEmail(user.getEmail());
        Optional<UserEntity> optionalUserEntity = userRepository.findById(users.getId());
        UserEntity userToUpdate = optionalUserEntity.get();
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userRepository.save(userToUpdate);

    }

    @Override
    public String deleteUserById(long id) throws UserDoesNotExist {

        if(!userExist(id)){

            throw new UserDoesNotExist("User Does Not Exist");
        }

        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        UserEntity userEntityToBeDeleted = optionalUserEntity.get();
        userRepository.delete(userEntityToBeDeleted);
        return "User deleted successfully ";

    }

    @Override
    public boolean checkIfUserExist(String email) {
        return userRepository.findByEmail(email) != null ? true : false;
    }

    @Override
    public boolean userExist(Long id) {
        return userRepository.findById(id) != null ? true : false;
    }

    private void encodePassword(UserEntity userEntity, UserData user) {
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
    }

}
