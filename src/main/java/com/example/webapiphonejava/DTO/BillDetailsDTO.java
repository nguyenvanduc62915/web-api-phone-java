package com.example.webapiphonejava.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillDetailsDTO {
    private int billDetailsId;
    private int quantity;
    private Double price;
    private LocalDate createAt;
    private LocalDate updateAt;
}
