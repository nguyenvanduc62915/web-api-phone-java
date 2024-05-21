package com.example.webapiphonejava.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDTO {
    private int customerId;
    @Size(max = 25, message = "Tên khách hàng cho phép tốt đa là 25 ký tự!")
    private String customerName;
    @Size(max = 15, message = "Số điện thoại khách hàng cho phép tốt đa là 15 ký tự!")
    private String phoneNumber;
    @Size(max = 100, message = "Email khách hàng cho phép tốt đa là 100 ký tự!")
    private String email;
    private LocalDate createAt;
    private LocalDate updateAt;
}
