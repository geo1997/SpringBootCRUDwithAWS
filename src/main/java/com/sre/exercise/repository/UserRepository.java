package com.sre.exercise.repository;

import com.sre.exercise.entity.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDTO, Integer> {
}
