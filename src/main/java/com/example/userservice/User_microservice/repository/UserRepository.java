package com.example.userservice.User_microservice.repository;

import com.example.userservice.User_microservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {


}
