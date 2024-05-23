package com.example.webapiphonejava.Services.Imp;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.BillDetailsDTO;

import java.util.List;

public interface BillDetailsImp {
    BaseResponse<List<BillDetailsDTO>> getAllBillDetails();
    BaseResponse<BillDetailsDTO> addBillDetails(BillDetailsDTO billDetailsDTO);
    BaseResponse<BillDetailsDTO> updateBillDetailsById(BillDetailsDTO billDetailsDTO, Integer billDetailsId);
    BaseResponse<BillDetailsDTO> deleteBillDetailsById(Integer billDetailsId);
}
