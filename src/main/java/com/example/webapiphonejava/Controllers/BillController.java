package com.example.webapiphonejava.Controllers;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.BillDTO;
import com.example.webapiphonejava.Services.BillService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/bill")
public class BillController {
    @Autowired
    private BillService billService;

    @GetMapping("/get_all")
    public ResponseEntity<BaseResponse<List<BillDTO>>> getAllBill(){
        BaseResponse<List<BillDTO>> baseResponse = billService.getAllBill();
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }

    @PostMapping("/add")
    public ResponseEntity<BaseResponse<BillDTO>> addBill(@Valid @RequestBody BillDTO billDTO){
        BaseResponse<BillDTO> baseResponse = billService.addBill(billDTO);
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse<BillDTO>> updateBillById(
            @Valid @RequestBody BillDTO billDTO,
            Integer billId
    ){
        BaseResponse<BillDTO> baseResponse = billService.updateBillById(billDTO, billId);
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<BaseResponse<BillDTO>> deleteBillById(@RequestParam("billId") Integer billId){
        BaseResponse<BillDTO> baseResponse = billService.deleteBillById(billId);
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }
}
