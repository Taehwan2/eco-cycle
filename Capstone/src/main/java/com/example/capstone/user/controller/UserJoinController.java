package com.example.capstone.user.controller;

import com.example.capstone.func.PasswordEncoderUtil;
import com.example.capstone.user.Service.UserService;
import com.example.capstone.user.db.UserEntity;
import com.example.capstone.user.mapper.UserMapper;
import com.example.capstone.user.model.LoginDto;
import com.example.capstone.user.model.UserPostDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
@RequiredArgsConstructor
@Slf4j
public class UserJoinController {

    private final UserService userService;
    private final UserMapper mapper;


    @PostMapping("")
    public ResponseEntity create(@RequestBody UserPostDto userPostDto){
        UserEntity userEntity = mapper.userPostDtoToUserEntity(userPostDto);
        return new ResponseEntity(userService.save(userEntity), HttpStatus.CREATED);
    }

    @PostMapping("/get")
    public ResponseEntity create(@RequestBody LoginDto loginDto){
       return  new ResponseEntity<>(userService.getUserAddress(loginDto),HttpStatus.ACCEPTED);
    }
}
