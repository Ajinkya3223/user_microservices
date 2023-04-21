package com.example.userservice.User_microservice.service;

import com.example.userservice.User_microservice.entity.User;
import com.example.userservice.User_microservice.exceptions.ResourceNotFoundException;
import com.example.userservice.User_microservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class UserServiceImpl implements  UserService{
   @Autowired
   private UserRepository userrepo;
    @Override
    public User saveUser(User user) {
       String randomid= UUID.randomUUID().toString();
       user.setUserId(randomid);
        return userrepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
          List<User> user = userrepo.findAll();
          return  user;
    }

    @Override
    public User getUser(String userid) {
        User user   =   userrepo.findById(userid).orElseThrow(()->new ResourceNotFoundException("user not found"));
    return user;
    }
}
