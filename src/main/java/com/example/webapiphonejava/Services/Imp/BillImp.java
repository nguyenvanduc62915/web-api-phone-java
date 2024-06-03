package com.example.webapiphonejava.Services.Imp;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.BillDTO;

import java.util.List;

public interface BillImp {
    BaseResponse<List<BillDTO>> getAllBill();
    BaseResponse<BillDTO> addBill(BillDTO billDTO, Integer customerId, Integer conditionId, Integer shipperId);
    BaseResponse<BillDTO> updateBillById(BillDTO billDTO, Integer billId, Integer customerId, Integer conditionId, Integer shipperId);
    BaseResponse<BillDTO> deleteBillById(Integer billId);
}
