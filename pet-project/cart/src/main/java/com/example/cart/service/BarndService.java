package com.example.cart.service;

import com.example.cart.dto.BrandDTO;
import com.example.cart.dto.CartDetailDTO;
import com.example.cart.entity.Brand;
import com.example.cart.entity.CartDetail;
import com.example.cart.repo.BrandRepo;
import com.example.cart.repo.CartDetailRepo;
import com.example.cart.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BarndService {
    @Autowired
    private BrandRepo brandRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveBrand(BrandDTO brandDTO){
        if(brandRepo.existsById(brandDTO.getBrandID())){
            return VarList.RSP_DUPLICATED;
        }else{
            brandRepo.save(modelMapper.map(brandDTO , Brand.class));
            return VarList.RSP_SUCCESS;
        }
    }
}
