package com.example.webapiphonejava.Services.Imp;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.ProductDTO;

import java.util.List;

public interface ProductImp {
    BaseResponse<List<ProductDTO>> getAllProduct();
    BaseResponse<ProductDTO> addProduct(ProductDTO productDTO, Integer categoryId);
    BaseResponse<ProductDTO> updateProductById(ProductDTO productDTO, Integer productId, Integer categoryId);
    BaseResponse<ProductDTO> deleteProductById(Integer productId);
}
