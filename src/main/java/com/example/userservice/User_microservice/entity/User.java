package com.example.userservice.User_microservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
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
@Transient
    private List<Rating> ratings=new ArrayList<>();
}
