package com.example.webapiphonejava.Services;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.BillDTO;
import com.example.webapiphonejava.Models.Bill;
import com.example.webapiphonejava.Models.Condition;
import com.example.webapiphonejava.Models.Customer;
import com.example.webapiphonejava.Models.Shipper;
import com.example.webapiphonejava.Repositories.BillRepository;
import com.example.webapiphonejava.Repositories.ConditionRepository;
import com.example.webapiphonejava.Repositories.CustomerRepository;
import com.example.webapiphonejava.Repositories.ShipperRepository;
import com.example.webapiphonejava.Services.Imp.BillImp;
import com.example.webapiphonejava.Utils.Constant;
import com.example.webapiphonejava.Utils.ConvertRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BillService implements BillImp {
    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ConditionRepository conditionRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ShipperRepository shipperRepository;

    @Autowired
    private ConvertRelationship convertRelationship;

    @Override
    public BaseResponse<List<BillDTO>> getAllBill() {
        BaseResponse<List<BillDTO>> baseResponse = new BaseResponse<>();
        List<BillDTO> billDTOList = new ArrayList<>();
        try {
            List<Bill> billList = billRepository.findAll();
            if (billList.isEmpty() || billList == null) {
                baseResponse.setMessage(Constant.EMPTY_ALL_BILL);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            for (Bill bill : billList) {
                BillDTO billDTO = new BillDTO();
                billDTO.setBillId(bill.getId());
                billDTO.setReceivingAddress(bill.getReceivingAddress());
                billDTO.setNote(bill.getNote());
                billDTO.setTotalAmount(bill.getTotalAmount());
                billDTO.setOrderDate(bill.getOrderDate());
                billDTO.setCreateAt(bill.getCreateAt());
                billDTO.setUpdateAt(bill.getUpdateAt());
                billDTO.setCustomer(convertRelationship.convertToCustomerDTO(bill.getCustomer()));
                billDTO.setCondition(convertRelationship.convertToConditionDTO(bill.getCondition()));
                billDTO.setShipper(convertRelationship.convertToShipperDTO(bill.getShipper()));
                billDTOList.add(billDTO);
            }
            baseResponse.setData(billDTOList);
            baseResponse.setMessage(Constant.SUCCESS_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex) {
            baseResponse.setMessage(Constant.ERROR_TO_GET_BILL);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<BillDTO> addBill(BillDTO billDTO, Integer conditionId, Integer customerId, Integer shipperId) {
        BaseResponse<BillDTO> baseResponse = new BaseResponse<>();
        try {
            Condition condition = conditionRepository.findConditionId(conditionId);
            if (condition == null) {
                baseResponse.setMessage(Constant.EMPTY_CONDITION_ID + conditionId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            Customer customer = customerRepository.findCustomerById(customerId);
            if (customer == null) {
                baseResponse.setMessage(Constant.EMPTY_CUSTOMER_ID + customerId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            Shipper shipper = shipperRepository.findShipperById(shipperId);
            if (shipper == null) {
                baseResponse.setMessage(Constant.EMPTY_SHIPPER_ID + shipperId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            Bill bill = new Bill();
            bill.setReceivingAddress(billDTO.getReceivingAddress());
            bill.setNote(billDTO.getNote());
            bill.setTotalAmount(billDTO.getTotalAmount());
            bill.setOrderDate(LocalDate.now());
            bill.setCreateAt(LocalDate.now());
            bill.setCondition(condition);
            bill.setCustomer(customer);
            bill.setShipper(shipper);
            billRepository.save(bill);
            baseResponse.setData(billDTO);
            baseResponse.setMessage(Constant.SUCCESS_ADD_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex) {
            baseResponse.setMessage(Constant.ERROR_TO_GET_BILL);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<BillDTO> updateBillById(BillDTO billDTO, Integer billId, Integer conditionId, Integer customerId, Integer shipperId) {
        BaseResponse<BillDTO> baseResponse = new BaseResponse<>();
        try {
            Bill bill = billRepository.findBillById(billId);
            if (bill == null) {
                baseResponse.setMessage(Constant.EMPTY_BILL_ID + billId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            Condition condition = conditionRepository.findConditionId(conditionId);
            if (condition == null) {
                baseResponse.setMessage(Constant.EMPTY_CONDITION_ID + conditionId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            Customer customer = customerRepository.findCustomerById(customerId);
            if (customer == null) {
                baseResponse.setMessage(Constant.EMPTY_CUSTOMER_ID + customerId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            Shipper shipper = shipperRepository.findShipperById(shipperId);
            if (shipper == null) {
                baseResponse.setMessage(Constant.EMPTY_SHIPPER_ID + shipperId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            bill.setNote(billDTO.getNote());
            bill.setTotalAmount(billDTO.getTotalAmount());
            bill.setReceivingAddress(billDTO.getReceivingAddress());
            bill.setOrderDate(billDTO.getOrderDate());
            bill.setUpdateAt(billDTO.getUpdateAt());
            bill.setCondition(condition);
            bill.setCustomer(customer);
            bill.setShipper(shipper);
            billRepository.save(bill);
            baseResponse.setData(billDTO);
            baseResponse.setMessage(Constant.SUCCESS_UPDATE_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex) {
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
            if (bill == null) {
                baseResponse.setMessage(Constant.EMPTY_BILL_ID + billId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            billRepository.delete(bill);
            baseResponse.setMessage(Constant.SUCCESS_DELETE_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex) {
            baseResponse.setMessage(Constant.ERROR_TO_GET_BILL);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }
}
