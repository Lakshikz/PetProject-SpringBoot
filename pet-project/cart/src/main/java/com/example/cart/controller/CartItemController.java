package com.example.cart.controller;

import com.example.cart.dto.BrandDTO;
import com.example.cart.dto.CartItemDTO;
import com.example.cart.dto.ResponseDTO;
import com.example.cart.entity.Product;
import com.example.cart.service.CartItemService;
import com.example.cart.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/v1/cartItem")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private ResponseDTO responseDTO;

    @Autowired
    RestTemplate restTemplate;

//    String productURL= "http://localhost:8082/api/v1/product/saveProductDetails";
//    String productResponse = restTemplate.getForObject(productURL, String.class);


    @PostMapping(value="/saveCartItem")
    public ResponseEntity saveCartItem(@RequestBody CartItemDTO cartItemDTO){
        try {
            String res = cartItemService.saveCartItem(cartItemDTO);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(cartItemDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            } else if (res.equals(("06"))) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Cart Details Already Existing");
                responseDTO.setContent(cartItemDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            } else {
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }
        } catch (Exception e) {
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}
