package com.example.bakalaurinis_project.repository;

import com.example.bakalaurinis_project.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository  extends JpaRepository <Users, Integer> {

    List<Users> findAllByUsername(String username);
    List<Users> findAllByEmail(String password);
    Users findByUsernameAndPassword(String username, String password);


}
