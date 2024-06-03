package com.example.webapiphonejava.Services;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.BillDetailsDTO;
import com.example.webapiphonejava.Models.Bill;
import com.example.webapiphonejava.Models.BillDetails;
import com.example.webapiphonejava.Models.Product;
import com.example.webapiphonejava.Repositories.BillDetailsRepository;
import com.example.webapiphonejava.Repositories.BillRepository;
import com.example.webapiphonejava.Repositories.ProductRepository;
import com.example.webapiphonejava.Services.Imp.BillDetailsImp;
import com.example.webapiphonejava.Utils.Constant;
import com.example.webapiphonejava.Utils.ConvertRelationship;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillDetailsService implements BillDetailsImp {
    @Autowired
    private BillDetailsRepository billDetailsRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ConvertRelationship convertRelationship;

    @Override
    public BaseResponse<List<BillDetailsDTO>> getAllBillDetails() {
        BaseResponse<List<BillDetailsDTO>>baseResponse = new BaseResponse<>();
        List<BillDetailsDTO> billDetailsDTOList = new ArrayList<>();
        try {
            List<BillDetails> billDetailsList = billDetailsRepository.findAll();
            if (billDetailsList.isEmpty() || billDetailsList == null){
                baseResponse.setMessage(Constant.EMPTY_ALL_BILLDETAILS);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
            }
            for (BillDetails billDetails : billDetailsList){
                BillDetailsDTO billDetailsDTO = new BillDetailsDTO();
                billDetailsDTO.setBillDetailsId(billDetails.getId());
                billDetailsDTO.setQuantity(billDetails.getQuantity());
                billDetailsDTO.setPrice(billDetails.getPrice());
                billDetailsDTO.setCreateAt(billDetails.getCreateAt());
                billDetailsDTO.setUpdateAt(billDetails.getUpdateAt());
                billDetailsDTO.setBill(convertRelationship.convertToBillDTO(billDetails.getBill()));
                billDetailsDTO.setProduct(convertRelationship.convertToProductDTO(billDetails.getProduct()));
                billDetailsDTOList.add(billDetailsDTO);
            }
            baseResponse.setData(billDetailsDTOList);
            baseResponse.setMessage(Constant.SUCCESS_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_BILLDETAILS);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<BillDetailsDTO> addBillDetails(BillDetailsDTO billDetailsDTO, Integer billId, Integer productId) {
        BaseResponse<BillDetailsDTO> baseResponse = new BaseResponse<>();
        try {
            Bill bill = billRepository.findBillById(billId);
            if (bill == null){
                baseResponse.setMessage(Constant.EMPTY_BILL_ID + billId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            Product product = productRepository.findProductById(productId);
            if (product == null){
                baseResponse.setMessage(Constant.EMPTY_PRODUCT_ID + productId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            BillDetails billDetails = new BillDetails();
            billDetails.setPrice(billDetailsDTO.getPrice());
            billDetails.setQuantity(billDetailsDTO.getQuantity());
            billDetails.setCreateAt(billDetailsDTO.getCreateAt());
            billDetails.setBill(bill);
            billDetails.setProduct(product);
            billDetailsRepository.save(billDetails);
            baseResponse.setData(billDetailsDTO);
            baseResponse.setMessage(Constant.SUCCESS_ADD_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_BILLDETAILS);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<BillDetailsDTO> updateBillDetailsById(BillDetailsDTO billDetailsDTO, Integer billDetailsId, Integer billId, Integer productId) {
        BaseResponse<BillDetailsDTO> baseResponse = new BaseResponse<>();
        try {
            BillDetails billDetails = billDetailsRepository.findBillDetailsById(billDetailsId);
            if (billDetails == null){
                baseResponse.setMessage(Constant.EMPTY_BILLDETAILS_ID + billDetailsId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            Bill bill = billRepository.findBillById(billId);
            if (bill == null){
                baseResponse.setMessage(Constant.EMPTY_BILL_ID + billId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            Product product = productRepository.findProductById(productId);
            if (product == null){
                baseResponse.setMessage(Constant.EMPTY_PRODUCT_ID + productId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            billDetails.setPrice(billDetailsDTO.getPrice());
            billDetails.setQuantity(billDetailsDTO.getQuantity());
            billDetails.setUpdateAt(billDetailsDTO.getUpdateAt());
            billDetails.setBill(bill);
            billDetails.setProduct(product);
            billDetailsRepository.save(billDetails);
            baseResponse.setData(billDetailsDTO);
            baseResponse.setMessage(Constant.SUCCESS_UPDATE_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_BILLDETAILS);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<BillDetailsDTO> deleteBillDetailsById(Integer billDetailsId) {
        BaseResponse<BillDetailsDTO> baseResponse = new BaseResponse<>();
        try {
            BillDetails billDetails = billDetailsRepository.findBillDetailsById(billDetailsId);
            if (billDetails == null){
                baseResponse.setMessage(Constant.EMPTY_BILLDETAILS_ID + billDetailsId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            billDetailsRepository.delete(billDetails);
            baseResponse.setMessage(Constant.SUCCESS_DELETE_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
        baseResponse.setMessage(Constant.ERROR_TO_GET_BILLDETAILS);
        baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
    }
        return baseResponse;
    }
}
