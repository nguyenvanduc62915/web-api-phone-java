package com.example.webapiphonejava.Services.Imp;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.CustomerDTO;

import java.util.List;

public interface CustomerImp {
    BaseResponse<List<CustomerDTO>> getAllCustomer();
    BaseResponse<CustomerDTO> addCustomer(CustomerDTO customerDTO);
    BaseResponse<CustomerDTO> updateCustomerById(CustomerDTO customerDTO, Integer customerId);
    BaseResponse<CustomerDTO> deleteCustomerById(Integer customerId);
}
