package com.example.webapiphonejava.Controllers;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.BillDetailsDTO;
import com.example.webapiphonejava.Repositories.BillDetailsRepository;
import com.example.webapiphonejava.Services.BillDetailsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/bill_details")
public class BillDetailsController {
    @Autowired
    private BillDetailsService billDetailsService;

    @GetMapping("/get_all")
    public ResponseEntity<BaseResponse<List<BillDetailsDTO>>> getAllBillDetails(){
        BaseResponse<List<BillDetailsDTO>> baseResponse = billDetailsService.getAllBillDetails();
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }

    @PostMapping("/add")
    public ResponseEntity<BaseResponse<BillDetailsDTO>> addBillDetails(@Valid @RequestBody BillDetailsDTO billDetailsDTO){
        BaseResponse<BillDetailsDTO> baseResponse = billDetailsService.addBillDetails(billDetailsDTO);
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse<BillDetailsDTO>> updateBillDetailsById(
            @Valid @RequestBody BillDetailsDTO billDetailsDTO,
            @RequestParam("billDetailsId") Integer billDetailsId
            ) {
        BaseResponse<BillDetailsDTO> baseResponse = billDetailsService.updateBillDetailsById(billDetailsDTO, billDetailsId);
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<BaseResponse<BillDetailsDTO>> deleteBillDetailsById(@RequestParam("billDetailsId") Integer billDetailsId){
        BaseResponse<BillDetailsDTO> baseResponse = billDetailsService.deleteBillDetailsById(billDetailsId);
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }
}
