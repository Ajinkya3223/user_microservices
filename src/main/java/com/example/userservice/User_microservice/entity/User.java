package com.example.userservice.User_microservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="micro_users")
public class User {
@Id
    private String userId;
@Column
    private String name;
@Column
    private String email;
@Column
    private String about;
}
