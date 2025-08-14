package com.example.E_Commerce.controller;

import com.example.E_Commerce.dto.UserDto;
import com.example.E_Commerce.model.User;
import com.example.E_Commerce.response.ApiResponse;
import com.example.E_Commerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody UserDto user){
        UserDto userDto= userService.register(user);
        return ResponseEntity.ok(new ApiResponse("Register Success" , userDto.getUsername()));
    }
    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody UserDto user){
        String token = userService.login(user);
        return ResponseEntity.ok(new ApiResponse("Success",token));
    }
}
