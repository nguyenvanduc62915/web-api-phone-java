package com.example.webapiphonejava.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductsOfSaleDTO {
    private int productOrSaleId;
    private int quantity;
    private LocalDate createAt;
    private LocalDate updateAt;
}
