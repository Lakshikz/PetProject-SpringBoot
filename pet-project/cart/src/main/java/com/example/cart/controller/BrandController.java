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
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Brand Controller Implementation
 * @author Lakshika De Zoysa
 */

@RestController
@RequestMapping("api/v1/brand")
public class BrandController {
    @Autowired
    private BarndService brandService;

    @Autowired
    private ResponseDTO responseDTO;

    /**
     * insert brand
     * @return updated {@link ResponseEntity} object
     */
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

    /**
     * update Brand
     * @param brandDTO
     * @return updated {@link ResponseEntity} object
     */
    @PutMapping(value = "/updateBrand")
    public ResponseEntity updateBrand(@RequestBody BrandDTO brandDTO) {
        try {
            String res = brandService.updateBrand(brandDTO);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(brandDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            } else if (res.equals(("01"))) {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("Not a existing Brand Details");
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

    /**
     * Delete brand by passing BrandID
     * @param brandID given brand id
     * @return updated {@link ResponseEntity} object
     */
    @DeleteMapping("/deleteBrand/{brandID}")
    public ResponseEntity deleteBrand(@PathVariable int brandID) {
        try {
            String res = brandService.deleteBrand(brandID);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Brand Deleted Successfully");
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

    /**
     * Get All Brand
     * @return  all {@link ResponseEntity} object
     */
    @GetMapping("/getAllBrands")
    public ResponseEntity getAllBrands() {
        try {
            List<BrandDTO> brandDTOList = brandService.getAllBrands();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(brandDTOList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);


        } catch (Exception e) {
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
