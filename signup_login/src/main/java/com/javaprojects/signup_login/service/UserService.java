package com.javaprojects.signup_login.service;

import com.javaprojects.signup_login.entity.User;
import java.util.*;

public interface UserService {
    List<User> findAll();
    User findById(int theId);
    User save(User theUser);
    void deleteById(int theId);
}
