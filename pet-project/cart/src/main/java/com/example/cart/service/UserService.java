package com.example.cart.service;

import com.example.cart.dto.UserDTO;
import com.example.cart.entity.User;
import com.example.cart.repo.UserRepo;
import com.example.cart.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveUser(UserDTO userDTO){
        if(userRepo.existsById(userDTO.getUserID())){
            return VarList.RSP_DUPLICATED;
        }else{
            userRepo.save(modelMapper.map(userDTO, User.class));
            return VarList.RSP_SUCCESS;
        }
    }
}
