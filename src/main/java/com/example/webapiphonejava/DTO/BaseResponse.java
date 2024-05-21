package com.example.webapiphonejava.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {
    private T data;
    private String message;
    private int code;
}
