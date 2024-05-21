package com.example.webapiphonejava.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillDTO {
    private int billId;
    private LocalDate orderDate;
    private Double totalAmount;
    @Size(max = 255, message = "Địa chỉ nhận hàng tối đa 255 ký tự!")
    private String receivingAddress;
    @Size(max = 255, message = "Ghi chú tối đa 255 ký tự!")
    private String note;
    private LocalDate createAt;
    private LocalDate updateAt;
}
