package com.example.cart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "CartDetail")
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartID;
    private int qty;
    private String dateAdded;

    @OneToOne
    @JoinColumn(
            name = "brand_ID",
            referencedColumnName = "brandID"

    )
    private Brand brand;

    @OneToOne
    @JoinColumn(
            name = "user_ID",
            referencedColumnName = "userID"
    )
    private User user;
}
