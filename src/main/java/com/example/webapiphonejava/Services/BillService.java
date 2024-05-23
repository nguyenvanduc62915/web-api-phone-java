package com.example.webapiphonejava.Services;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.BillDTO;
import com.example.webapiphonejava.Models.Bill;
import com.example.webapiphonejava.Repositories.BillRepository;
import com.example.webapiphonejava.Services.Imp.BillImp;
import com.example.webapiphonejava.Utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillService implements BillImp {
    @Autowired
    private BillRepository billRepository;
    @Override
    public BaseResponse<List<BillDTO>> getAllBill() {
        BaseResponse<List<BillDTO>> baseResponse = new BaseResponse<>();
        List<BillDTO> billDTOList = new ArrayList<>();
        try {
            List<Bill> billList = billRepository.findAll();
            if (billList.isEmpty() || billList == null){
                baseResponse.setMessage(Constant.EMPTY_ALL_BILL);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            for (Bill bill : billList){
                BillDTO billDTO = new BillDTO();
                billDTO.setBillId(bill.getId());
                billDTO.setReceivingAddress(bill.getReceivingAddress());
                billDTO.setNote(bill.getNote());
                billDTO.setTotalAmount(bill.getTotalAmount());
                billDTO.setOrderDate(bill.getOrderDate());
                billDTO.setCreateAt(bill.getCreateAt());
                billDTO.setUpdateAt(bill.getUpdateAt());
                billDTOList.add(billDTO);
            }
            baseResponse.setData(billDTOList);
            baseResponse.setMessage(Constant.SUCCESS_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_BILL);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<BillDTO> addBill(BillDTO billDTO) {
        BaseResponse<BillDTO> baseResponse = new BaseResponse<>();
        try {
            Bill bill = new Bill();
            bill.setId(billDTO.getBillId());
            bill.setReceivingAddress(billDTO.getReceivingAddress());
            bill.setNote(billDTO.getNote());
            bill.setTotalAmount(billDTO.getTotalAmount());
            bill.setOrderDate(billDTO.getOrderDate());
            bill.setCreateAt(billDTO.getCreateAt());
            billRepository.save(bill);
            baseResponse.setData(billDTO);
            baseResponse.setMessage(Constant.SUCCESS_ADD_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_BILL);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<BillDTO> updateBillById(BillDTO billDTO, Integer billId) {
        BaseResponse<BillDTO> baseResponse = new BaseResponse<>();
        try {
            Bill bill = billRepository.findBillById(billId);
            if (bill == null){
                baseResponse.setMessage(Constant.EMPTY_BILL_ID + billId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            bill.setNote(billDTO.getNote());
            bill.setTotalAmount(billDTO.getTotalAmount());
            bill.setReceivingAddress(billDTO.getReceivingAddress());
            bill.setOrderDate(billDTO.getOrderDate());
            bill.setUpdateAt(billDTO.getUpdateAt());
            billRepository.save(bill);
            baseResponse.setData(billDTO);
            baseResponse.setMessage(Constant.SUCCESS_UPDATE_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_BILL);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<BillDTO> deleteBillById(Integer billId) {
        BaseResponse<BillDTO> baseResponse = new BaseResponse<>();
        try {
            Bill bill = billRepository.findBillById(billId);
            if (bill == null){
                baseResponse.setMessage(Constant.EMPTY_BILL_ID + billId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            billRepository.delete(bill);
            baseResponse.setMessage(Constant.SUCCESS_DELETE_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_BILL);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }
}
