package com.example.cart.dto;

import com.example.cart.entity.Brand;
import com.example.cart.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartDetailDTO {
    private int cartID;
    private int qty;
    private int dateAdded;
    private Brand brand;
    private User user;
}
