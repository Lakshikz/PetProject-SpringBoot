package com.example.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int productID;
    private String productName;
    private String description;
    private double price;
}
