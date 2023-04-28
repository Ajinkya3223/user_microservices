package com.example.userservice.User_microservice.service;

import com.example.userservice.User_microservice.entity.Rating;
import com.example.userservice.User_microservice.entity.User;
import com.example.userservice.User_microservice.exceptions.ResourceNotFoundException;
import com.example.userservice.User_microservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
@Slf4j
public class UserServiceImpl implements  UserService{
   @Autowired
   private UserRepository userrepo;
   @Autowired
   private RestTemplate resttemplate;
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
 //fetching the rating data http://localhost:8083/ratings/user/92b61195-4156-4f19-b475-775b92ef1deb
 ArrayList<Rating> forobject= resttemplate.getForObject("http://localhost:8083/ratings/user/92b61195-4156-4f19-b475-775b92ef1deb", ArrayList.class);
    log.info("{}",forobject);
    user.setRatings(forobject);
    return user;
    }

    @Override
    public void deleteUser(String userid) {
        userrepo.deleteById(userid);
    }

}
