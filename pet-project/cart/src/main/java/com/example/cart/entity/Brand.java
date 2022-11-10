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
@Table(name ="Brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brandID;
    private String brandName;

    @OneToMany(targetEntity = CartDetail.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_ID" , referencedColumnName = "brandID")
    private List<CartDetail> cartDetails;
}
