package com.example.capstone.address.service;

import com.example.capstone.address.db.AddressEntity;
import com.example.capstone.address.db.AddressRepository;
import com.example.capstone.user.Service.UserService;
import com.example.capstone.user.db.UserEntity;
import com.example.capstone.user.db.UserRepository;
import com.example.capstone.useraddress.db.UserAddress;
import com.example.capstone.useraddress.db.UserAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final UserAddressRepository useraddressRepository;
    private final UserService userService;
    public AddressEntity save2(AddressEntity addressEntity){
        addressRepository.save(addressEntity);
        UserEntity userEntity = userService.findOneByPhoneNum("010-4444-5678");
        UserAddress userAddress = UserAddress.builder()
                        .userEntity(userEntity)
                                .addressEntity(addressEntity).build();
        useraddressRepository.save(userAddress);
        return addressEntity;
    }
    public AddressEntity save(AddressEntity addressEntity){
        addressRepository.save(addressEntity);
        return addressEntity;
    }
}
