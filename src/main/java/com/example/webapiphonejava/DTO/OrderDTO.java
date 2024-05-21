package com.example.webapiphonejava.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    private int orderId;
    @Size(max = 255, message = "Tình tràng đơn hàng tối đa 255 ký tự!")
    private String orderStatus;
    private LocalDate createAt;
    private LocalDate updateAt;
}

