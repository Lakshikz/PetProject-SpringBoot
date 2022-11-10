package com.example.cart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;
    private String userName;
    private String userEmail;
    private String userMobile;

    @OneToMany(targetEntity = CartDetail.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_ID" , referencedColumnName = "userID")
    private List<CartDetail> cartDetails;
}
