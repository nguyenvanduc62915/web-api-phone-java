package com.example.webapiphonejava.Controllers;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.ShipperDTO;
import com.example.webapiphonejava.Services.ShipperService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/shipper")
public class ShipperController {
    @Autowired
    private ShipperService shipperService;

    @GetMapping("/get_all")
    public ResponseEntity<BaseResponse<List<ShipperDTO>>> getAllShipper() {
        BaseResponse<List<ShipperDTO>> baseResponse = shipperService.getAllShipper();
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }

    @PostMapping("/add")
    public ResponseEntity<BaseResponse<ShipperDTO>> addShipper(@Valid @RequestBody ShipperDTO shipperDTO){
        BaseResponse<ShipperDTO> baseResponse = shipperService.addShipper(shipperDTO);
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse<ShipperDTO>> updateShipperById(
            @Valid @RequestBody ShipperDTO shipperDTO,
            @RequestParam("shipperId") Integer shipperId
    ) {
        BaseResponse<ShipperDTO> baseResponse = shipperService.updateShipperById(shipperDTO, shipperId);
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<BaseResponse<ShipperDTO>> deleteShipperById(@RequestParam("shipperId") Integer shipperId){
        BaseResponse<ShipperDTO> baseResponse = shipperService.deleteShipperById(shipperId);
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }
}
