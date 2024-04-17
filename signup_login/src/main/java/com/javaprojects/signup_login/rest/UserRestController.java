package com.javaprojects.signup_login.rest;


import com.javaprojects.signup_login.entity.User;
import com.javaprojects.signup_login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
//@RequestMapping("")
public class UserRestController {
    private UserService userService;

    //inject user dao (user constructor injection)
    @Autowired
    public UserRestController(UserService theUserService){
        userService = theUserService;
    }
    // expose "/users" and return a list of employees

   /*
    *
    * I'm trying to access my register.html file through the url, but it's not working.
    *
    */
    @GetMapping("/register")
    public String getRegisterPage() {
        return "register";
    }


    @GetMapping("/users")
    @ResponseBody
    public List<User> findAll() { return userService.findAll();}

    @GetMapping("/users/{userId}")
    @ResponseBody
    public User getUser(@PathVariable int userId){
        User theUser = userService.findById(userId);
        if(theUser==null){
            throw new RuntimeException("User id not found - " + userId);
        }
        return theUser;
    }

    @CrossOrigin(origins = "http://localhost:8080/register")
    @PostMapping("/register")
    @ResponseBody
    public User addUser(@RequestBody User theUser){
        theUser.setId(0); /* in the method inside the class UserServiceImpl, if the
        id = 0, create a new user, else update the user. Setting the Id = 0 we guarantee that
        the user will be inserted instead of updated*/

        User dbUser = userService.save(theUser);
        //System.out.println(dbUser.getEmail() + " has been successfully registered!");
        return dbUser;
    }
    @PutMapping("/users")
    @ResponseBody
    public User updateUser(@RequestBody User theUser){
        User dbUser = userService.save(theUser);
        return dbUser;
    }
    @DeleteMapping("/users/{userId}")
    @ResponseBody
    public String deleteUser(@PathVariable int userId){
        User theUser = userService.findById(userId);
        if (theUser==null){
            throw new RuntimeException("User id not found - " + userId);
        }
        userService.deleteById(userId);
        return "Deleted user id - " + userId;
    }
}
