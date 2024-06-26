package com.example.webapiphonejava.Services;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.ProductsOfSaleDTO;
import com.example.webapiphonejava.Models.Product;
import com.example.webapiphonejava.Models.ProductsOfSale;
import com.example.webapiphonejava.Repositories.ProductRepository;
import com.example.webapiphonejava.Repositories.ProductsOfSaleRepository;
import com.example.webapiphonejava.Services.Imp.ProductsOfSaleImp;
import com.example.webapiphonejava.Utils.Constant;
import com.example.webapiphonejava.Utils.ConvertRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsOfSaleService implements ProductsOfSaleImp {
    @Autowired
    private ProductsOfSaleRepository productsOfSaleRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ConvertRelationship convertRelationship;

    @Override
    public BaseResponse<List<ProductsOfSaleDTO>> getAllProductsOfSale() {
        BaseResponse<List<ProductsOfSaleDTO>> baseResponse = new BaseResponse<>();
        List<ProductsOfSaleDTO> productsOfSaleDTOList = new ArrayList<>();
        try {
            List<ProductsOfSale> productsOfSaleList = productsOfSaleRepository.findAll();
            if (productsOfSaleList.isEmpty() || productsOfSaleList == null){
                baseResponse.setMessage(Constant.EMPTY_ALL_PRODUCTSOFSALE);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            for (ProductsOfSale productsOfSale : productsOfSaleList){
                ProductsOfSaleDTO productsOfSaleDTO = new ProductsOfSaleDTO();
                productsOfSaleDTO.setProductOrSaleId(productsOfSale.getId());
                productsOfSaleDTO.setQuantity(productsOfSale.getQuantity());
                productsOfSaleDTO.setCreateAt(productsOfSale.getCreateAt());
                productsOfSaleDTO.setUpdateAt(productsOfSale.getUpdateAt());
                productsOfSaleDTO.setProduct(convertRelationship.convertToProductDTO(productsOfSale.getProduct()));
                productsOfSaleDTOList.add(productsOfSaleDTO);
            }
            baseResponse.setData(productsOfSaleDTOList);
            baseResponse.setMessage(Constant.SUCCESS_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_PRODUCTSOFSALE);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<ProductsOfSaleDTO> addProductsOfSale(ProductsOfSaleDTO productsOfSaleDTO, Integer productId) {
        BaseResponse<ProductsOfSaleDTO> baseResponse = new BaseResponse<>();
        try {
            Product product = productRepository.findProductById(productId);
            if (product == null){
                baseResponse.setMessage(Constant.EMPTY_PRODUCT_ID + productId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            ProductsOfSale productsOfSale = new ProductsOfSale();
            productsOfSale.setId(productsOfSaleDTO.getProductOrSaleId());
            productsOfSale.setQuantity(productsOfSaleDTO.getQuantity());
            productsOfSale.setCreateAt(productsOfSaleDTO.getCreateAt());
            productsOfSale.setProduct(product);
            productsOfSaleRepository.save(productsOfSale);
            baseResponse.setData(productsOfSaleDTO);
            baseResponse.setMessage(Constant.SUCCESS_ADD_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_PRODUCTSOFSALE);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }


    @Override
    public BaseResponse<ProductsOfSaleDTO> updateProductsOfSaleById(ProductsOfSaleDTO productsOfSaleDTO, Integer productsOfSaleId, Integer productId) {
        BaseResponse<ProductsOfSaleDTO> baseResponse = new BaseResponse<>();
        try {
            ProductsOfSale productsOfSale = productsOfSaleRepository.findProductsOfSaleById(productsOfSaleId);
            if (productsOfSale == null){
                baseResponse.setMessage(Constant.EMPTY_PRODUCTSOFSALE_ID + productsOfSaleId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            Product product = productRepository.findProductById(productId);
            if (product == null){
                baseResponse.setMessage(Constant.EMPTY_PRODUCT_ID + productId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            productsOfSale.setId(productsOfSaleDTO.getProductOrSaleId());
            productsOfSale.setQuantity(productsOfSaleDTO.getQuantity());
            productsOfSale.setUpdateAt(productsOfSaleDTO.getUpdateAt());
            productsOfSale.setProduct(product);
            productsOfSaleRepository.save(productsOfSale);
            baseResponse.setData(productsOfSaleDTO);
            baseResponse.setMessage(Constant.SUCCESS_UPDATE_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_PRODUCTSOFSALE);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<ProductsOfSaleDTO> deleteProductsOfSaleById(Integer productsOfSaleId) {
        BaseResponse<ProductsOfSaleDTO> baseResponse = new BaseResponse<>();
        try {
            ProductsOfSale productsOfSale = productsOfSaleRepository.findProductsOfSaleById(productsOfSaleId);
            if (productsOfSale == null){
                baseResponse.setMessage(Constant.EMPTY_PRODUCTSOFSALE_ID + productsOfSaleId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            productsOfSaleRepository.delete(productsOfSale);
            baseResponse.setMessage(Constant.SUCCESS_DELETE_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_PRODUCTSOFSALE);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }
}
