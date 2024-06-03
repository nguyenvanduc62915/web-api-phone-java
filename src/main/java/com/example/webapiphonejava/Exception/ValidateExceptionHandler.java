package com.example.webapiphonejava.Exception;

import com.example.webapiphonejava.DTO.BaseResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ValidateExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<Map<String, Object>>> handlerValidateExceptions(MethodArgumentNotValidException ex){
        Map<String, Object> body = new LinkedHashMap<>();
        BaseResponse<Map<String, Object>> baseResponse = new BaseResponse<>();
        body.put("Error", ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getDefaultMessage())
                .collect(Collectors.toList()));
        body.put("Time", LocalDate.now());
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }
}
