package com.example.webapiphonejava.Services.Imp;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.BillDTO;

import java.util.List;

public interface BillImp {
    BaseResponse<List<BillDTO>> getAllBill();
    BaseResponse<BillDTO> addBill(BillDTO billDTO);
    BaseResponse<BillDTO> updateBillById(BillDTO billDTO, Integer billId);
    BaseResponse<BillDTO> deleteBillById(Integer billId);
}
