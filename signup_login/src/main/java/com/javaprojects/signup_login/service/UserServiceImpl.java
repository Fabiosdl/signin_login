package com.javaprojects.signup_login.service;

import com.javaprojects.signup_login.entity.User;
import com.javaprojects.signup_login.dao.UserDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) { this.userDao = userDao; }


    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(int theId) {
        return userDao.findById(theId);
    }

    @Transactional
    @Override
    public User save(User theUser) {
        return userDao.save(theUser);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        userDao.deleteById(theId);
    }
}