package com.example.capstone.useraddress.service;

import com.example.capstone.useraddress.db.UserAddress;
import com.example.capstone.useraddress.db.UserAddressRepository;
import com.example.capstone.useraddress.model.UserAddressDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserAddressService {
    private final UserAddressRepository userAddressRepository;

    public UserAddress save(UserAddress userAddress){
        userAddressRepository.save(userAddress);
        return userAddress;
    }

    public  List<UserAddressDTO> find(String phonenum){
        return userAddressRepository.findByUserEntityPhonenum(phonenum);
    }
}
