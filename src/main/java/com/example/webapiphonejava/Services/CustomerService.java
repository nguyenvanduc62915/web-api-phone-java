package com.example.webapiphonejava.Services;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.CustomerDTO;
import com.example.webapiphonejava.Models.Customer;
import com.example.webapiphonejava.Repositories.CustomerRepository;
import com.example.webapiphonejava.Services.Imp.CustomerImp;
import com.example.webapiphonejava.Utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements CustomerImp {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public BaseResponse<List<CustomerDTO>> getAllCustomer() {
        BaseResponse<List<CustomerDTO>> baseResponse = new BaseResponse<>();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        try {
           List<Customer> customerList = customerRepository.findAll();
           if (customerList.isEmpty() || customerList == null){
               baseResponse.setMessage(Constant.EMPTY_ALL_CUSTOMER);
               baseResponse.setCode(Constant.SUCCESS_CODE);
               return baseResponse;
           }
           for (Customer customer : customerList){
               CustomerDTO customerDTO = new CustomerDTO();
               customerDTO.setCustomerId(customer.getId());
               customerDTO.setCustomerName(customer.getCustomerName());
               customerDTO.setEmail(customer.getEmail());
               customerDTO.setPhoneNumber(customer.getPhoneNumber());
               customerDTO.setCreateAt(customer.getCreateAt());
               customerDTO.setUpdateAt(customer.getUpdateAt());
               customerDTOList.add(customerDTO);
           }
           baseResponse.setData(customerDTOList);
           baseResponse.setMessage(Constant.SUCCESS_MESSAGE);
           baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_CUSTOMER);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<CustomerDTO> addCustomer(CustomerDTO customerDTO) {
        BaseResponse<CustomerDTO> baseResponse = new BaseResponse<>();
        try {
            Customer customer = new Customer();
            customer.setCustomerName(customerDTO.getCustomerName());
            customer.setPhoneNumber(customerDTO.getPhoneNumber());
            customer.setEmail(customerDTO.getEmail());
            customer.setCreateAt(customerDTO.getCreateAt());
            customerRepository.save(customer);
            baseResponse.setData(customerDTO);
            baseResponse.setMessage(Constant.SUCCESS_ADD_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_CUSTOMER);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<CustomerDTO> updateCustomerById(CustomerDTO customerDTO, Integer customerId) {
        BaseResponse<CustomerDTO> baseResponse = new BaseResponse<>();
        try {
            Customer customer = customerRepository.findCustomerById(customerId);
            if (customer == null){
                baseResponse.setMessage(Constant.EMPTY_CUSTOMER_ID + customerId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            customer.setCustomerName(customerDTO.getCustomerName());
            customer.setPhoneNumber(customerDTO.getPhoneNumber());
            customer.setEmail(customerDTO.getEmail());
            customer.setUpdateAt(customerDTO.getUpdateAt());
            customerRepository.save(customer);
            baseResponse.setData(customerDTO);
            baseResponse.setMessage(Constant.SUCCESS_UPDATE_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception exception){
            baseResponse.setMessage(Constant.ERROR_TO_GET_CUSTOMER);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<CustomerDTO> deleteCustomerById(Integer customerId) {
        BaseResponse<CustomerDTO> baseResponse = new BaseResponse<>();
        try {
            Customer customer = customerRepository.findCustomerById(customerId);
            if (customer == null){
                baseResponse.setMessage(Constant.EMPTY_CUSTOMER_ID + customerId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            customerRepository.delete(customer);
            baseResponse.setMessage(Constant.SUCCESS_DELETE_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception exception){
            baseResponse.setMessage(Constant.ERROR_TO_GET_CUSTOMER);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }
}
