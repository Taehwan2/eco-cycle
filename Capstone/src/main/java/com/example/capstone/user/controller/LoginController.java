package com.example.capstone.user.controller;


import com.example.capstone.user.model.LoginDto;
import com.example.capstone.func.PasswordEncoderUtil;
import com.example.capstone.user.model.LoginUser;
import com.example.capstone.user.db.UserEntity;
import com.example.capstone.user.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("login")
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;
//    private final AuthenticationManager authenticationManager;

//    @PostMapping("")
//    public ResponseEntity<String> login(@RequestBody LoginDto loginRequest) {
//        Authentication authentication = new UsernamePasswordAuthenticationToken(loginRequest.getData(), loginRequest.getUserpw());
//        try {
//            log.info("{}",loginRequest.getData());
//            Authentication authenticatedUser = authenticationManager.authenticate(authentication);
//            SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
//            return ResponseEntity.ok("인증 성공");
//        } catch (AuthenticationException e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("인증 실패");
//        }
//    }
//    @PostMapping()
//    public Map<String, String> login(@RequestBody LoginUser loginUser) {
//        Map<String, String> map = new HashMap<>();
//        if (loginUser.getType().equals("0")) {
//            UserEntity phonenumUser = userService.findOneByPhoneNum(loginUser.getUserid());
//            if (PasswordEncoderUtil.match(loginUser.getUserpw(), phonenumUser.getPassword())) {
//                map.put("login", "true");
//                return map;
//            } else {
//                map.put("login", "false");
//                return map;
//            }
//        } else {
//            UserEntity emailUser = userService.findOneByEmail(loginUser.getUserid());
//            if (PasswordEncoderUtil.match(loginUser.getUserpw(), emailUser.getPassword())) {
//                map.put("login", "true");
//                return map;
//            } else {
//                map.put("login", "false");
//                return map;
//            }
//
//        }
//
//    }

    @PostMapping("/search_user")
    private ResponseEntity search(@RequestBody LoginDto loginDto){
        Map<String, String> map = new HashMap<>();
        if (loginDto.getType().equals("0")) {
            if(userService.findOneByPhoneNum(loginDto.getData())==null){
                map.put("user","false");
            }else{
                map.put("user","true");
            }
        } else {
            if(userService.findOneByEmail(loginDto.getData())==null){
                map.put("user","false");
            }else{
                map.put("user","true");
            }
        }

        return new ResponseEntity(map,HttpStatus.OK);
    }


    @PostMapping("/check_signup")
    private Map<String, String> check(@RequestBody UserEntity userEntity) {
        Map<String, String> map = new HashMap<>();
        log.info(userEntity.getPhonenum());
        try {
            UserEntity foundUser = userService.findOneByPhoneNum(userEntity.getPhonenum());
            if (foundUser == null) {
                map.put("user", "false");
                return map;
            }
            map.put("user", "true");
            return map;
        } catch (NullPointerException e) {
            // 예외 처리 코드 작성
            map.put("user", "false");
            return map;
        }
    }


    @PostMapping("/changepw")
    public Map<String, String> changepw(@RequestBody LoginDto loginDto) {
        Map<String, String> map = new HashMap<>();
        if (loginDto.getType().equals("0")) {
            UserEntity phonenumUser = userService.findOneByPhoneNum(loginDto.getData());
            if (PasswordEncoderUtil.match(loginDto.getUserpw(), phonenumUser.getPassword())) {
                 map.put("change","false");
                return map;
            }
            phonenumUser.setPassword(PasswordEncoderUtil.encode(loginDto.getUserpw()));
            userService.save(phonenumUser);
            map.put("change","true");
            return map;
        } else {
            UserEntity emailUser = userService.findOneByEmail(loginDto.getData());
            if (PasswordEncoderUtil.match(loginDto.getUserpw(), emailUser.getPassword())) {
                map.put("change","false");
                return map;
            }
            emailUser.setPassword(PasswordEncoderUtil.encode(loginDto.getUserpw()));
            userService.save(emailUser);
            map.put("change","true");
            return map;
        }

    }
}
