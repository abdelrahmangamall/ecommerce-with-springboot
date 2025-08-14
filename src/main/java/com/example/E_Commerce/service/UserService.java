package com.example.E_Commerce.service;

import com.example.E_Commerce.dto.UserDto;
import com.example.E_Commerce.model.Role;
import com.example.E_Commerce.model.User;
import com.example.E_Commerce.repo.UserRepository;
import com.example.E_Commerce.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
   private final UserRepository userRepository;
   private final PasswordEncoder passwordEncoder;
   private final AuthenticationManager authenticationManager;
   private final JwtUtil jwtUtil;
    public UserDto register(UserDto userDto){
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        user.setRole(Role.USER);
        userRepository.save(user);
        return userDto;
    }
    public String login(UserDto userDto){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.getUsername() , userDto.getPassword())
        );
        User user = userRepository.findByUsername(userDto.getUsername())
                .orElseThrow();
        return jwtUtil.generateToken(user);
    }
}
