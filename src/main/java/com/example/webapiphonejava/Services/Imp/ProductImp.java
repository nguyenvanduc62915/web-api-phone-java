package com.example.webapiphonejava.Services.Imp;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.ProductDTO;

import java.util.List;

public interface ProductImp {
    BaseResponse<List<ProductDTO>> getAllProduct();
    BaseResponse<ProductDTO> addProduct(ProductDTO productDTO);
    BaseResponse<ProductDTO> updateProductById(ProductDTO productDTO, Integer productId);
    BaseResponse<ProductDTO> deleteProductById(Integer productId);
}
