package com.example.cart.dto;

import com.example.cart.entity.Brand;
import com.example.cart.entity.CartDetail;
import com.example.cart.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartDetailDTO {
    private int cartID;
    private int qty;
    private String dateAdded;


}
