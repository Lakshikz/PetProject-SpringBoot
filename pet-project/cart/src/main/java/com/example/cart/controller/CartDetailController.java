package com.example.cart.controller;

import com.example.cart.dto.CartDetailDTO;
import com.example.cart.dto.ResponseDTO;
import com.example.cart.service.CartDetailService;
import com.example.cart.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cart")
public class CartDetailController {
    @Autowired
    private CartDetailService cartDetailService;

    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping(value = "/saveCartDetails")
    public ResponseEntity saveCartDetail(@RequestBody CartDetailDTO cartDetailDTO) {
        try {
            String res = cartDetailService.saveCartDetail(cartDetailDTO);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(cartDetailDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            } else if (res.equals(("06"))) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Cart Details Already Existing");
                responseDTO.setContent(cartDetailDTO);
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

    @PutMapping(value = "/updateCartDetails")
    public ResponseEntity updateCartDetail(@RequestBody CartDetailDTO cartDetailDTO) {
        try {
            String res = cartDetailService.updateCartDetail(cartDetailDTO);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(cartDetailDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            } else if (res.equals(("01"))) {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("Not a existing Cart Details");
                responseDTO.setContent(cartDetailDTO);
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

    @DeleteMapping("/deleteCartDetail/{cartID}")
    public ResponseEntity deleteCartDetail(@PathVariable int cartID) {
        try {
            String res = cartDetailService.deleteCartDetail(cartID);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Delete Success");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
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
