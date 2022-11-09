package com.example.cart.repo;

import com.example.cart.entity.Brand;
import com.example.cart.entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepo extends JpaRepository<Brand, Integer> {
}
