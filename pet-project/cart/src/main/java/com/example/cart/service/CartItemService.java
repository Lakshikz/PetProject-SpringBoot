package com.example.cart.service;

import com.example.cart.dto.CartDetailDTO;
import com.example.cart.dto.CartItemDTO;
import com.example.cart.entity.CartDetail;
import com.example.cart.entity.CartItem;
import com.example.cart.repo.CartItemRepo;
import com.example.cart.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CartItemService {
    @Autowired
    private CartItemRepo cartItemRepo;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Insert CartItem
     * @param cartItemDTO
     * @return
     */
    public String saveCartItem(CartItemDTO cartItemDTO){
        if(cartItemRepo.existsById(cartItemDTO.getCartItemID())){
            return VarList.RSP_DUPLICATED;
        }else{
            cartItemRepo.save(modelMapper.map(cartItemDTO , CartItem.class));
            return VarList.RSP_SUCCESS;
        }
    }
}
