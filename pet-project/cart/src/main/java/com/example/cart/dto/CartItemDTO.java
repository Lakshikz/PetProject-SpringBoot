package com.example.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartItemDTO {
    private int cartItemID;
    private String cartItemName;
    private double unitCost;
}
