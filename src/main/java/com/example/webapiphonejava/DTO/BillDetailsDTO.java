package com.example.webapiphonejava.DTO;

import com.example.webapiphonejava.Models.Bill;
import com.example.webapiphonejava.Models.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillDetailsDTO {
    private int billDetailsId;
    private int quantity;
    private Double price;
    private LocalDate createAt;
    private LocalDate updateAt;
    private BillDTO bill;
    private ProductDTO product;
}
