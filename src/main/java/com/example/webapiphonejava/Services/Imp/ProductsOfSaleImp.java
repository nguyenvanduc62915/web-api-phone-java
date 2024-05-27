package com.example.webapiphonejava.Services.Imp;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.ProductsOfSaleDTO;
import com.example.webapiphonejava.Models.ProductsOfSale;

import java.util.List;

public interface ProductsOfSaleImp {
    BaseResponse<List<ProductsOfSaleDTO>> getAllProductsOfSale();
    BaseResponse<ProductsOfSaleDTO> addProductsOfSale(ProductsOfSaleDTO productsOfSaleDTO);
    BaseResponse<ProductsOfSaleDTO> updateProductsOfSaleById(ProductsOfSaleDTO productsOfSaleDTO, Integer productsOfSaleId);
    BaseResponse<ProductsOfSaleDTO> deleteProductsOfSaleById(Integer productsOfSaleId);
}
