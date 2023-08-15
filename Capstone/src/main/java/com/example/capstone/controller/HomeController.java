package com.example.capstone.controller;


import com.example.capstone.sms.model.MessageDTO;
import com.example.capstone.model.AppVersion;
import com.example.capstone.sms.service.SmsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequestMapping("/")
@RestController
@RequiredArgsConstructor
public class HomeController {

    //Update Version expression
    private String version = "1.0.0";

    //Json파일로 변경하기 위한 객체
    Gson gson = new Gson();
    JsonObject jsonObject = new JsonObject();

    //SMS 인증을 위한 클래스
    final private SmsService smsService;

    @PostMapping()
    public Map<String, String> versionCheck(@RequestBody AppVersion appVersion){
        Map<String,String> answer= new HashMap<>();
        if(version.equals(appVersion.getAppversion())){
            answer.put("connection","true");
            return answer;
        }
        answer.put("connection","false");
        return answer;
    }

    @GetMapping("{accesstocken}/{refreshtocken}")
    public String home(@PathVariable(name = "accesstocken") String accesstocken, @PathVariable(name = "refreshtocken") String refreshtocken) {
        System.out.println(accesstocken);
        System.out.println(refreshtocken);
        return "hello-oauth2";
    }


    //SMS인증 문자 보내는 메서드
    @PostMapping("/sms/send")
//    public SmsResponseDTO sendSms(@RequestBody MessageDTO messageDto, Model model) throws JsonProcessingException, RestClientException, URISyntaxException, InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
    public Map<String, String> sendSms(@RequestBody MessageDTO messageDto, Model model) throws JsonProcessingException, RestClientException, URISyntaxException, InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        //MessageDTO ---> 자신의 번호와, 보낼 문자 내용을 입력한다.
//        SmsResponseDTO response = smsService.sendSms(messageDto);
        String name = smsService.sendSms(messageDto);
        Map<String,String> map = new HashMap<>();
        map.put("authcode",name);
        return map;
    }



}
