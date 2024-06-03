package com.example.webapiphonejava.Services.Imp;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.BillDetailsDTO;

import java.util.List;

public interface BillDetailsImp {
    BaseResponse<List<BillDetailsDTO>> getAllBillDetails();
    BaseResponse<BillDetailsDTO> addBillDetails(BillDetailsDTO billDetailsDTO, Integer billId, Integer productId);
    BaseResponse<BillDetailsDTO> updateBillDetailsById(BillDetailsDTO billDetailsDTO, Integer billDetailsId, Integer billId, Integer productId);
    BaseResponse<BillDetailsDTO> deleteBillDetailsById(Integer billDetailsId);
}
