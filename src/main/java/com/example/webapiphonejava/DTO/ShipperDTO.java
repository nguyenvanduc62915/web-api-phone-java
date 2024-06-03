package com.example.webapiphonejava.DTO;

import com.example.webapiphonejava.Models.Bill;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShipperDTO {
    private int shipperId;
    @Size(max = 50, message = "Tên nhân viên giao hàng tối ta 50 ký tự!")
    private String shipperName;
    @Size(max = 11, message = "Số điện thoại tối đa 11 ký tự!")
    private String phoneShipperOne;
    @Size(max = 11, message = "Số điện thoại tối đa 11 ký tự!")
    private String phoneShipperTwo;
    private LocalDate createAt;
    private LocalDate updateAt;
    private List<BillDTO> bills;
}
