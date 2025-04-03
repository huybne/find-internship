package com.internship.user_service.exception;

import com.internship.user_service.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;


@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse<String>> handleJsonParserException() {
        return ResponseEntity.badRequest().body(ApiResponse.<String>builder().success(false)
                .data("Invalid request body. Please check the data format.").build());
    }

    @ExceptionHandler(value = NoResourceFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleNoResourceFoundException() {
        return ResponseEntity.badRequest().body(ApiResponse.<String>builder().success(false)
                .data("Invalid resource access").build());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ApiResponse<String>> handleAppException(Exception appException) {
        return ResponseEntity.badRequest().body(ApiResponse.<String>builder().success(false)
                .data(appException.getMessage()).build());
    }
}
