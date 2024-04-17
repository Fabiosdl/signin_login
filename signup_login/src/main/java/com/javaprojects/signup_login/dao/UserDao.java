package com.javaprojects.signup_login.dao;

import com.javaprojects.signup_login.entity.User;
import java.util.List;

//DAO data access object
public interface UserDao {
    List<User> findAll();
    User findById(int theId);
    User save(User theUser);
    void deleteById(int theId);
}

