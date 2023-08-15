package com.example.capstone.address.controller;

import com.example.capstone.address.addressMapper.AddressMapper;
import com.example.capstone.address.model.AddressDto;
import com.example.capstone.address.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/Address")
public class AddressCotroller {
    private final AddressService addressService;
    private final AddressMapper mapper;
    @PostMapping("")
    public void save(@RequestBody AddressDto addressDto){
        addressService.save(mapper.AddressDtoToAddressEntity(addressDto));
    }
}
