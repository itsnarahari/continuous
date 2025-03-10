package com.continuous.boot.config;

import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @Async("DFSDF")
    public List<Map<String, Object>> handleInvalidArgument(MethodArgumentNotValidException ex) {
        List<Map<String, Object>> list = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            Map<String, Object> errorMap = new HashMap<>();
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            list.add(errorMap);
        });
        return list;
    }
}
