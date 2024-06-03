package com.example.webapiphonejava.Controllers;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.ProductDTO;
import com.example.webapiphonejava.Services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/get_all")
    public ResponseEntity<BaseResponse<List<ProductDTO>>> getAllProduct() {
        BaseResponse<List<ProductDTO>> baseResponse = productService.getAllProduct();
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }

    @PostMapping("/add")
    public ResponseEntity<BaseResponse<ProductDTO>> addProduct(
            @Valid @RequestBody ProductDTO productDTO,
            @RequestParam("categoryId") Integer categoryId
    ) {
        BaseResponse<ProductDTO> baseResponse = productService.addProduct(productDTO, categoryId);
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse<ProductDTO>> updateProductById(
            @Valid @RequestBody ProductDTO productDTO,
            @RequestParam("productId") Integer productId,
            @RequestParam("categoryId") Integer categoryId
    ) {
        BaseResponse<ProductDTO> baseResponse = productService.updateProductById(productDTO, productId, categoryId);
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<BaseResponse<ProductDTO>> deleteProductById(@RequestParam("productId") Integer productId) {
        BaseResponse<ProductDTO> baseResponse = productService.deleteProductById(productId);
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }
}
