package com.gwabstech.RestApi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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



    // add user
    @PostMapping("/newUser")
    public ResponseEntity<Object> addUser(@RequestBody User user){

       User savedUser =  service.addUser(user);
       URI location =ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();

       return ResponseEntity.created(location).build();
    }

}

