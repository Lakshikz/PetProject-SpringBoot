package com.example.cart.dto;

import com.example.cart.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private int userID;
    private String userName;
    private String userEmail;
    private String userMobile;
    private User user;
}
