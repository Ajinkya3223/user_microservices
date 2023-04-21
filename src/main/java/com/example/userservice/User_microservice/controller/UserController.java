package com.example.userservice.User_microservice.controller;

import com.example.userservice.User_microservice.entity.User;
import com.example.userservice.User_microservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/save")
    public ResponseEntity<User> createUSer(@RequestBody User user){
      User user1=userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(user1);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User>getUserbyid(@PathVariable String id){
         User user=userService.getUser(id);
          return ResponseEntity.ok(user);
    }
    @GetMapping("/getalluser")
    public ResponseEntity<List<User>> getAlluser(){
        List<User> user2 =userService.getAllUser();
        return ResponseEntity.ok(user2);
    }

}