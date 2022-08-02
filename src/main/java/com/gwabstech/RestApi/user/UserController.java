package com.gwabstech.RestApi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDaoService service;
    // retrieve all users
    @GetMapping("/all_Users")
    public List<User> getAllUsers(){
        return service.getUserList();
    }

    // userById
    @GetMapping("/user_by_id/{id}")
    public User getUserById(@PathVariable int id){
        return service.findUserById(id);
    }

    @PostMapping("/newUser")
    public void addUser(@RequestBody User user){
        service.addUser(user);
    }
    // add user
}
