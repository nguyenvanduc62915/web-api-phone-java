package com.example.webapiphonejava.Controllers;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.ProductsOfSaleDTO;
import com.example.webapiphonejava.Services.ProductsOfSaleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/products_of_sale")
public class ProductsOfSaleController {
    @Autowired
    private ProductsOfSaleService productsOfSaleService;

    @GetMapping("/get_all")
    public ResponseEntity<BaseResponse<List<ProductsOfSaleDTO>>> getAllProductsOfSale(){
        BaseResponse<List<ProductsOfSaleDTO>> baseResponse = productsOfSaleService.getAllProductsOfSale();
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PostMapping("/add")
    public ResponseEntity<BaseResponse<ProductsOfSaleDTO>> addProductsOfSale(
            @Valid @RequestBody ProductsOfSaleDTO productsOfSaleDTO,
            @RequestParam("productId") Integer productId
            ){
        BaseResponse<ProductsOfSaleDTO> baseResponse = productsOfSaleService.addProductsOfSale(productsOfSaleDTO, productId);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse<ProductsOfSaleDTO>> updateProductsOfSaleById(
            @Valid @RequestBody ProductsOfSaleDTO productsOfSaleDTO,
            @RequestParam("productsOfSaleId") Integer productsOfSaleId,
            @RequestParam("productId") Integer productId
    ) {
        BaseResponse<ProductsOfSaleDTO> baseResponse = productsOfSaleService.updateProductsOfSaleById(productsOfSaleDTO, productsOfSaleId, productId);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<BaseResponse<ProductsOfSaleDTO>> deleteProductsOfSaleById(@RequestParam("productsOfSaleId") Integer productsOfSaleId){
        BaseResponse<ProductsOfSaleDTO> baseResponse = productsOfSaleService.deleteProductsOfSaleById(productsOfSaleId);
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }
}
