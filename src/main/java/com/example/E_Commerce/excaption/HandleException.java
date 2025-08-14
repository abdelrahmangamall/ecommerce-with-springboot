package com.example.E_Commerce.excaption;

import com.example.E_Commerce.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleException {
    @ExceptionHandler
    public ResponseEntity<ApiResponse> HandleResourceNotFound(ResourceNotFound exc){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(exc.getMessage());
        apiResponse.setData(null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(apiResponse);
    }
    @ExceptionHandler
    public ResponseEntity<ApiResponse> HandleException(Exception exc){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(exc.getMessage());
        apiResponse.setData(null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(apiResponse);
    }
}




// AOP