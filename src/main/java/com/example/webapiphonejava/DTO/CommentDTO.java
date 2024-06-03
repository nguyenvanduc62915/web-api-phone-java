package com.example.webapiphonejava.DTO;

import com.example.webapiphonejava.Models.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentDTO {
    private int commentId;
    @Size(max = 25, message = "Họ và tên tối đa 25 ký tự!")
    private String fullName;
    private LocalDate dateAndTime;
    @Size(max = 255, message = "Nội dung người bình luận tối ta 255 ký tự!")
    private String content;
    @Size(max = 25, message = "Điện người bình luận tối ta 25 ký tự!")
    private String phone;
    private LocalDate createAt;
    private LocalDate updateAt;
    private ProductDTO product;
}
