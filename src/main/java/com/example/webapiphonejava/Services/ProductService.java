package com.example.webapiphonejava.Services;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.ProductDTO;
import com.example.webapiphonejava.Models.Product;
import com.example.webapiphonejava.Repositories.ProductRepository;
import com.example.webapiphonejava.Services.Imp.ProductImp;
import com.example.webapiphonejava.Utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductImp {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public BaseResponse<List<ProductDTO>> getAllProduct() {
        BaseResponse<List<ProductDTO>> baseResponse = new BaseResponse<>();
        List<ProductDTO> productDTOList = new ArrayList<>();
        try {
            List<Product> productList = productRepository.findAll();
            if (productList.isEmpty() || productList == null) {
                baseResponse.setMessage(Constant.EMPTY_ALL_PRODUCT);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            for (Product product : productList) {
                ProductDTO productDTO = new ProductDTO();
                productDTO.setProductId(product.getId());
                productDTO.setProductImage(product.getProductImage());
                productDTO.setProductName(product.getProductName());
                productDTO.setCamera(product.getCamera());
                productDTO.setAmount(product.getAmount());
                productDTO.setBattery(product.getBattery());
                productDTO.setColor(product.getColor());
                productDTO.setConnection(product.getConnection());
                productDTO.setDimension(product.getDimension());
                productDTO.setMemory(product.getMemory());
                productDTO.setWeight(product.getWeight());
                productDTO.setWarranty(product.getWarranty());
                productDTO.setStartSale(product.getStartSale());
                productDTO.setSound(product.getSound());
                productDTO.setSale(product.getSale());
                productDTO.setPrice(product.getPrice());
                productDTO.setOperatingSystem(product.getOperatingSystem());
                productDTO.setMemoryCard(product.getMemoryCard());
                productDTO.setEndSale(product.getEndSale());
                productDTO.setCreateAt(product.getCreateAt());
                productDTO.setUpdateAt(product.getUpdateAt());
                productDTOList.add(productDTO);
            }
            baseResponse.setData(productDTOList);
            baseResponse.setMessage(Constant.SUCCESS_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex) {
            baseResponse.setMessage(Constant.ERROR_TO_GET_PRODUCT);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<ProductDTO> addProduct(ProductDTO productDTO) {
        BaseResponse<ProductDTO> baseResponse = new BaseResponse<>();
        try {
            Product product = new Product();
            product.setProductImage(productDTO.getProductImage());
            product.setProductName(productDTO.getProductName());
            product.setCamera(productDTO.getCamera());
            product.setAmount(productDTO.getAmount());
            product.setBattery(productDTO.getBattery());
            product.setColor(productDTO.getColor());
            product.setConnection(productDTO.getConnection());
            product.setDimension(productDTO.getDimension());
            product.setMemory(productDTO.getMemory());
            product.setWeight(productDTO.getWeight());
            product.setWarranty(productDTO.getWarranty());
            product.setStartSale(productDTO.getStartSale());
            product.setSound(productDTO.getSound());
            product.setSale(productDTO.getSale());
            product.setPrice(productDTO.getPrice());
            product.setOperatingSystem(productDTO.getOperatingSystem());
            product.setMemoryCard(productDTO.getMemoryCard());
            product.setEndSale(productDTO.getEndSale());
            product.setCreateAt(productDTO.getCreateAt());
            productRepository.save(product);
            baseResponse.setData(productDTO);
            baseResponse.setMessage(Constant.SUCCESS_ADD_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex) {
            baseResponse.setMessage(Constant.ERROR_TO_GET_PRODUCT);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<ProductDTO> updateProductById(ProductDTO productDTO, Integer productId) {
        BaseResponse<ProductDTO> baseResponse = new BaseResponse<>();
        try {
            Product product = productRepository.findProductById(productId);
            if (product == null){
                baseResponse.setMessage(Constant.EMPTY_PRODUCT_ID + productId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            product.setProductImage(productDTO.getProductImage());
            product.setProductName(productDTO.getProductName());
            product.setCamera(productDTO.getCamera());
            product.setAmount(productDTO.getAmount());
            product.setBattery(productDTO.getBattery());
            product.setColor(productDTO.getColor());
            product.setConnection(productDTO.getConnection());
            product.setDimension(productDTO.getDimension());
            product.setMemory(productDTO.getMemory());
            product.setWeight(productDTO.getWeight());
            product.setWarranty(productDTO.getWarranty());
            product.setStartSale(productDTO.getStartSale());
            product.setSound(productDTO.getSound());
            product.setSale(productDTO.getSale());
            product.setPrice(productDTO.getPrice());
            product.setOperatingSystem(productDTO.getOperatingSystem());
            product.setMemoryCard(productDTO.getMemoryCard());
            product.setEndSale(productDTO.getEndSale());
            product.setUpdateAt(productDTO.getUpdateAt());
            productRepository.save(product);
            baseResponse.setData(productDTO);
            baseResponse.setMessage(Constant.SUCCESS_UPDATE_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex) {
            baseResponse.setMessage(Constant.ERROR_TO_GET_PRODUCT);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<ProductDTO> deleteProductById(Integer productId) {
        BaseResponse<ProductDTO> baseResponse = new BaseResponse<>();
        try {
            Product product = productRepository.findProductById(productId);
            if (product == null){
                baseResponse.setMessage(Constant.EMPTY_PRODUCT_ID + productId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            productRepository.delete(product);
            baseResponse.setMessage(Constant.SUCCESS_DELETE_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex) {
            baseResponse.setMessage(Constant.ERROR_TO_GET_PRODUCT);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }
}
