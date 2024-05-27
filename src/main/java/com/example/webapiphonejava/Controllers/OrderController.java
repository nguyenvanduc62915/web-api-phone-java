package com.example.webapiphonejava.Controllers;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.OrderDTO;
import com.example.webapiphonejava.Services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/get_all")
    public ResponseEntity<BaseResponse<List<OrderDTO>>> getAllOrder(){
        BaseResponse<List<OrderDTO>> baseResponse = orderService.getAllOrder();
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }

    @PostMapping("/add")
    public ResponseEntity<BaseResponse<OrderDTO>> addOrder(@Valid @RequestBody OrderDTO orderDTO){
        BaseResponse<OrderDTO> baseResponse = orderService.addOrder(orderDTO);
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse<OrderDTO>> updateOrderById(
            @Valid @RequestBody OrderDTO orderDTO,
            @RequestParam("orderId") Integer orderId
    ) {
        BaseResponse<OrderDTO> baseResponse = orderService.updateOrderById(orderDTO, orderId);
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<BaseResponse<OrderDTO>> deleteOrderById(@RequestParam("orderId") Integer orderId){
        BaseResponse<OrderDTO> baseResponse = orderService.deleteOrderById(orderId);
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }
}
