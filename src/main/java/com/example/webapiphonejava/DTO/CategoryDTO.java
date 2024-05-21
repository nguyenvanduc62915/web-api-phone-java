package com.example.webapiphonejava.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO {
    private int categoryId;
    @Size(max = 50, message = "Tên danh mục cho phép tối đa 50 ký tự!")
    private String categoryName;
    private LocalDate createAt;
    private LocalDate updateAt;
}
