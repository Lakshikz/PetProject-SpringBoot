package com.example.cart.dto;

import com.example.cart.entity.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BrandDTO {
    private int brandID;
    private String brandName;
    private Brand brand;
}
