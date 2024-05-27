package com.example.webapiphonejava.Services;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.OrderDTO;
import com.example.webapiphonejava.Models.Order;
import com.example.webapiphonejava.Repositories.OrderRepository;
import com.example.webapiphonejava.Services.Imp.OrderImp;
import com.example.webapiphonejava.Utils.Constant;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements OrderImp {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public BaseResponse<List<OrderDTO>> getAllOrder() {
        BaseResponse<List<OrderDTO>> baseResponse = new BaseResponse<>();
        List<OrderDTO> orderDTOList = new ArrayList<>();
        try {
            List<Order> orderList = orderRepository.findAll();
            if (orderList.isEmpty() || orderList == null){
                baseResponse.setMessage(Constant.EMPTY_ALL_ORDER);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            for (Order order : orderList){
                OrderDTO orderDTO = new OrderDTO();
                orderDTO.setOrderId(orderDTO.getOrderId());
                orderDTO.setOrderStatus(order.getOrderStatus());
                orderDTO.setCreateAt(order.getCreateAt());
                orderDTO.setUpdateAt(order.getUpdateAt());
                orderDTOList.add(orderDTO);
            }
            baseResponse.setData(orderDTOList);
            baseResponse.setMessage(Constant.SUCCESS_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_ORDER);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<OrderDTO> addOrder(OrderDTO orderDTO) {
        BaseResponse<OrderDTO> baseResponse = new BaseResponse<>();
        try {
            Order order = new Order();
            order.setId(orderDTO.getOrderId());
            order.setOrderStatus(orderDTO.getOrderStatus());
            order.setCreateAt(orderDTO.getCreateAt());
            orderRepository.save(order);
            baseResponse.setData(orderDTO);
            baseResponse.setMessage(Constant.SUCCESS_ADD_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_ORDER);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<OrderDTO> updateOrderById(OrderDTO orderDTO, Integer orderId) {
        BaseResponse<OrderDTO> baseResponse = new BaseResponse<>();
        try {
            Order order = orderRepository.findOrderById(orderId);
            if (order == null){
                baseResponse.setMessage(Constant.EMPTY_ORDER_ID  + orderId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            order.setId(orderDTO.getOrderId());
            order.setOrderStatus(orderDTO.getOrderStatus());
            order.setUpdateAt(orderDTO.getUpdateAt());
            orderRepository.save(order);
            baseResponse.setData(orderDTO);
            baseResponse.setMessage(Constant.SUCCESS_UPDATE_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_ORDER);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<OrderDTO> deleteOrderById(Integer orderId) {
        BaseResponse<OrderDTO> baseResponse = new BaseResponse<>();
        try {
            Order order = orderRepository.findOrderById(orderId);
            if (order == null){
                baseResponse.setMessage(Constant.EMPTY_ORDER_ID + orderId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            orderRepository.delete(order);
            baseResponse.setMessage(Constant.SUCCESS_DELETE_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_ORDER);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }
}
