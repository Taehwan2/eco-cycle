package com.example.capstone.controller;

import com.example.capstone.func.PasswordEncoderUtil;
import com.example.capstone.address.db.AddressEntity;
import com.example.capstone.point.db.Point;
import com.example.capstone.user.mapper.UserMapper;
import com.example.capstone.user.model.UserPostDto;
import com.example.capstone.useraddress.db.UserAddress;
import com.example.capstone.user.db.UserEntity;
import com.example.capstone.address.service.AddressService;
import com.example.capstone.useraddress.service.UserAddressService;
import com.example.capstone.user.Service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("signup")
@RequiredArgsConstructor

public class JoinController {
    private final UserService userService;
    private final AddressService addressService;
    private final UserAddressService userAddressService;
    private final UserMapper userMapper;
    ObjectMapper objectMapper = new ObjectMapper();
    Map<String, String> map = new HashMap<>();

    @PostMapping()
    private ResponseEntity save(
            @RequestParam("userPostDto") String userPostDtoString,
            @RequestParam("addressEntity") String addressEntityString,
            @RequestParam("profile") MultipartFile profile
    ) throws IOException {
        //변수 초기화

        //objectMapper을 통해서 userEntitiy와 addressEntity를 따로 구분
        List<Object> objects = someFunction(userPostDtoString,addressEntityString);
        UserPostDto userPostDto = (UserPostDto) objects.get(0);
        AddressEntity addressEntity = (AddressEntity) objects.get(1);
        //초기화 하는 부분
        UserEntity userEntity = userMapper.userPostDtoToUserEntity(userPostDto);
        Point userpoint = new Point("0", "0", userEntity);
        userEntity.setProfile(profile.getBytes());
        userEntity.addPoint(userpoint);

        userService.save(userEntity);
        addressService.save(addressEntity);

        UserAddress userAddress = UserAddress.builder().userEntity(userEntity).addressEntity(addressEntity).build();
        userAddressService.save(userAddress);
        map.put("signup", "true");

        return new ResponseEntity(map, HttpStatus.CREATED);

    }

    public List<Object> someFunction(String userPostDtoString, String addressEntityString) {
        UserPostDto userPostDto = null;
        AddressEntity addressEntity = null;
        try {
            userPostDto = objectMapper.readValue(userPostDtoString, UserPostDto.class);
            addressEntity = objectMapper.readValue(addressEntityString, AddressEntity.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        List<Object> result = new ArrayList<>();
        result.add(userPostDto);
        result.add(addressEntity);
        return result;
    }

    @GetMapping("{phonenum}")
    public void Check(@PathVariable(name = "phonenum") String phonenum) {
        userService.get_address(phonenum);
    }

    @PostMapping("/address")
    public ResponseEntity save_address(@RequestBody Map<String, Object> request) {
        UserEntity userEntity = userService.findOneByPhoneNum(objectMapper.convertValue(request.get("userEntity"), UserEntity.class).getPhonenum());
        AddressEntity addressEntity = objectMapper.convertValue(request.get("addressEntity"), AddressEntity.class);
        addressService.save(addressEntity);
        UserAddress userAddress = UserAddress.builder().userEntity(userEntity).addressEntity(addressEntity).build();
        userAddressService.save(userAddress);
        return new ResponseEntity(map, HttpStatus.CREATED);
    }
}
