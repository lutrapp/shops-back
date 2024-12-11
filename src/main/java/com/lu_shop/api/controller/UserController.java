package com.lu_shop.api.controller;

import com.lu_shop.api.dto.UserRequestDTO;
import com.lu_shop.api.dto.UserResponseDTO;
import com.lu_shop.api.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody @Valid UserRequestDTO userRequest) {
        UserResponseDTO userResponse = userService.register(userRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }
}