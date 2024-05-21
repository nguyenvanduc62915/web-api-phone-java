package com.example.webapiphonejava.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private int userId;
    @Size(max = 50, message = "Tên người dùng cho phép tốt đa là 50 ký tự!")
    private String name;
    @Size(max = 50, message = "Tài khoản người dùng cho phép tốt đa là 50 ký tự!")
    private String userName;
    @Size(max = 25, message = "Mật khẩu người dùng cho phép tốt đa là 25 ký tự!")
    private String password;
    private LocalDate createAt;
    private LocalDate updateAt;
}
