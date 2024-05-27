package com.example.webapiphonejava.Services.Imp;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.OrderDTO;

import java.util.List;

public interface OrderImp {
    BaseResponse<List<OrderDTO>> getAllOrder();
    BaseResponse<OrderDTO> addOrder(OrderDTO orderDTO);
    BaseResponse<OrderDTO> updateOrderById(OrderDTO orderDTO, Integer orderId);
    BaseResponse<OrderDTO> deleteOrderById(Integer orderId);
}
