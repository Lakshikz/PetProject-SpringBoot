package com.example.product.service;

import com.example.product.dto.ProductDTO;
import com.example.product.entity.Product;
import com.example.product.repo.ProductRepo;
import com.example.product.util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveProduct(ProductDTO productDTO) {
        if (productRepo.existsById(productDTO.getProductID())) {
            return VarList.RSP_DUPLICATED;
        } else {
            productRepo.save(modelMapper.map(productDTO, Product.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateProduct(ProductDTO productDTO) {
        if (productRepo.existsById(productDTO.getProductID())) {
            productRepo.save(modelMapper.map(productDTO, Product.class));
            return VarList.RSP_SUCCESS;
        } else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public String deleteProduct(int productID) {
        if (productRepo.existsById(productID)) {
            productRepo.deleteById(productID);
            return VarList.RSP_SUCCESS;
        } else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepo.findAll();
        return modelMapper.map(productList, new TypeToken<ArrayList<ProductDTO>>() {
        }.getType());
    }
}
