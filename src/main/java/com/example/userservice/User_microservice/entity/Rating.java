package com.example.userservice.User_microservice.entity;

import lombok.*;

import java.util.List;
@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private  String userId;
    private String ratingId;
    private String hotelId;
    private int rating;
    private String feedback;

}
