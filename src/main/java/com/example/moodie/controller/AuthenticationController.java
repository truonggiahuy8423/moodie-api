package com.example.moodie.controller;

import com.example.moodie.dto.request.LoginRequest;
import com.example.moodie.dto.request.RegisterRequest;
import com.example.moodie.dto.response.AppResponse;
import com.example.moodie.dto.response.LoginResponse;
import com.example.moodie.dto.response.RegisterResponse;
import com.example.moodie.service.UserService;
import com.example.moodie.util.ApiMessage;
import com.mysql.cj.log.Log;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AppResponse<RegisterResponse>> register(@RequestBody @Valid RegisterRequest user) {
        RegisterResponse registerResponse = userService.register(user);
        return new ResponseEntity<AppResponse<RegisterResponse>>(new AppResponse<RegisterResponse>(HttpStatus.OK.value(),
                ApiMessage.SUCCESS, registerResponse), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AppResponse<LoginResponse>> login(@RequestBody @Valid LoginRequest user) {
        System.out.println(user.getEmail());
        LoginResponse loginResponse = userService.login(user);
        System.out.println(user.getEmail());
        return new ResponseEntity<AppResponse<LoginResponse>>(new AppResponse<LoginResponse>(HttpStatus.OK.value(),
                ApiMessage.SUCCESS, loginResponse), HttpStatus.OK);
    }

    @PostMapping("/test")
    public ResponseEntity<AppResponse<Integer>> test() {
        return new ResponseEntity<AppResponse<Integer>>(new AppResponse<Integer>(HttpStatus.OK.value(),
                ApiMessage.SUCCESS, 1), HttpStatus.OK);
    }
}
