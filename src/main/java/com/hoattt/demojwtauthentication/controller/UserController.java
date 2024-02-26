package com.hoattt.demojwtauthentication.controller;

import com.hoattt.demojwtauthentication.dto.UserDto;
import com.hoattt.demojwtauthentication.dto.request.UserDtoRequest;
import com.hoattt.demojwtauthentication.dto.response.UserDtoResponse;
import com.hoattt.demojwtauthentication.entity.User;
import com.hoattt.demojwtauthentication.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;
    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hi User");
    }

    @PutMapping("/update")
    public UserDtoResponse updateUser(@Valid @RequestBody UserDtoRequest userDtoRequest) throws ParseException {
        return userService.updateUser(userDtoRequest);
    }
}
