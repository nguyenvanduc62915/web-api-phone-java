package com.example.webapiphonejava.Controllers;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.CustomerDTO;
import com.example.webapiphonejava.Services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/get_all")
    public ResponseEntity<BaseResponse<List<CustomerDTO>>> getAllCustomer(){
        BaseResponse<List<CustomerDTO>> baseResponse = customerService.getAllCustomer();
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PostMapping("/add")
    public ResponseEntity<BaseResponse<CustomerDTO>> addCustomer(@Valid @RequestBody CustomerDTO customerDTO){
        BaseResponse<CustomerDTO> baseResponse = customerService.addCustomer(customerDTO);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse<CustomerDTO>> updateCustomerById(
            @Valid @RequestBody CustomerDTO customerDTO,
            @RequestParam("customerId") Integer customerId
    ) {
       BaseResponse<CustomerDTO> baseResponse = customerService.updateCustomerById(customerDTO, customerId);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<BaseResponse<CustomerDTO>> deleteCustomerById(@RequestParam("customerId") Integer customerId){
        BaseResponse<CustomerDTO> baseResponse = customerService.deleteCustomerById(customerId);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }
}
