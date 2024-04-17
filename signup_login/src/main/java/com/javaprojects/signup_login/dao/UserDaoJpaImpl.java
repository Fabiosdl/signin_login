package com.javaprojects.signup_login.dao;

import com.javaprojects.signup_login.entity.User;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoJpaImpl implements UserDao {


    // define a field for entitymanager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public UserDaoJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<User> findAll() {
        //create a query
        TypedQuery<User> theQuery = entityManager.createQuery("from User", User.class);
        //execute query and get result list
        List<User> users = theQuery.getResultList();

        return users;
    }
    @Override
    public User findById(int theId) {
        User theUser = entityManager.find(User.class, theId);
        return theUser;
    }
    @Override
    public User save(User theUser) {
        User dbUser = entityManager.merge(theUser);
        return dbUser;
    }
    @Override
    public void deleteById(int theId) {
        User theUser = entityManager.find(User.class, theId);
        entityManager.remove(theUser);
    }
}
