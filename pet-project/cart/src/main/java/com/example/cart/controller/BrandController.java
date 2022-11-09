package com.example.cart.controller;

import com.example.cart.dto.BrandDTO;
import com.example.cart.dto.CartDetailDTO;
import com.example.cart.dto.ResponseDTO;
import com.example.cart.service.BarndService;
import com.example.cart.service.CartDetailService;
import com.example.cart.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/brand")
public class BrandController {
    @Autowired
    private BarndService brandService;

    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping(value = "/saveBrand")
    public ResponseEntity saveBrand(@RequestBody BrandDTO brandDTO){
        try {
            String res = brandService.saveBrand(brandDTO);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(brandDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            } else if (res.equals(("06"))) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Cart Details Already Existing");
                responseDTO.setContent(brandDTO);
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
