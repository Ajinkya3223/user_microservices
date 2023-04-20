package com.example.userservice.User_microservice.service;

import com.example.userservice.User_microservice.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUser();

    User getUser(String userid);
}
