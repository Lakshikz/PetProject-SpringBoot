package com.example.cart.service;

import com.example.cart.dto.BrandDTO;
import com.example.cart.dto.CartDetailDTO;
import com.example.cart.entity.Brand;
import com.example.cart.entity.CartDetail;
import com.example.cart.repo.BrandRepo;
import com.example.cart.repo.CartDetailRepo;
import com.example.cart.util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
/**
 * Brand Service Implementation
 * @author Lakshika De Zoysa
 */
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
    public String updateBrand(BrandDTO brandDTO) {
        if (brandRepo.existsById(brandDTO.getBrandID())) {
            brandRepo.save(modelMapper.map(brandDTO, Brand.class));
            return VarList.RSP_SUCCESS;
        } else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
    public String deleteBrand(int brandID) {
        if (brandRepo.existsById(brandID)) {
            brandRepo.deleteById(brandID);
            return VarList.RSP_SUCCESS;
        } else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
    public List<BrandDTO> getAllBrands() {
        List<Brand> brandList = brandRepo.findAll();
        return modelMapper.map(brandList, new TypeToken<ArrayList<BrandDTO>>() {
        }.getType());
    }
}
