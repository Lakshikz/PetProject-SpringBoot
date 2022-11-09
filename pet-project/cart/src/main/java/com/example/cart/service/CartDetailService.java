package com.example.cart.service;

import com.example.cart.dto.CartDetailDTO;
import com.example.cart.entity.CartDetail;
import com.example.cart.repo.CartDetailRepo;
import com.example.cart.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CartDetailService {

    @Autowired
    private CartDetailRepo cartDetailRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveCartDetail(CartDetailDTO cartDetailDTO){
        if(cartDetailRepo.existsById(cartDetailDTO.getCartID())){
            return VarList.RSP_DUPLICATED;
        }else{
            cartDetailRepo.save(modelMapper.map(cartDetailDTO , CartDetail.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateCartDetail(CartDetailDTO cartDetailDTO) {
        if (cartDetailRepo.existsById(cartDetailDTO.getCartID())) {
            cartDetailRepo.save(modelMapper.map(cartDetailDTO, CartDetail.class));
            return VarList.RSP_SUCCESS;
        } else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
    public String deleteCartDetail(int cartID) {
        if (cartDetailRepo.existsById(cartID)) {
            cartDetailRepo.deleteById(cartID);
            return VarList.RSP_SUCCESS;
        } else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
