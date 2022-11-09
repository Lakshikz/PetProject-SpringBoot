package com.example.cart.repo;

import com.example.cart.entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDetailRepo extends JpaRepository<CartDetail, Integer> {
}
