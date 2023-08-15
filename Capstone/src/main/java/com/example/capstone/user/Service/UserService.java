package com.example.capstone.user.Service;

import com.example.capstone.address.db.AddressEntity;
import com.example.capstone.config.UserAuthorityService;
import com.example.capstone.user.db.UserEntity;
import com.example.capstone.user.db.UserRepository;
import com.example.capstone.user.model.LoginDto;
import com.example.capstone.useraddress.db.UserAddress;
import com.example.capstone.useraddress.model.UserAddressDTO;
import com.example.capstone.useraddress.service.UserAddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@Slf4j
@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    @Lazy
    private final UserAuthorityService authorityUtils;
    private final PasswordEncoder passwordEncoder;

    private final UserAddressService userAddressService;

    public UserEntity save(UserEntity userEntity){
        existsByPhonenum(userEntity.getPhonenum());
        String encryptedPassword = passwordEncoder.encode(userEntity.getPassword());
        userEntity.setPassword(encryptedPassword);
        List<String> roles = authorityUtils.createAuthorites(userEntity.getEmail());
        userEntity.setRoles(roles);
        repository.save(userEntity);
        return userEntity;
    }

    private boolean existsByPhonenum(String phonenum) {
        Optional<UserEntity> userEntity = repository.findByPhonenum(phonenum);
        return userEntity.isEmpty();
    }

    public UserEntity findOneByEmail(String email){
        return repository.findByEmail(email).orElse(null);
    }

    public UserEntity findOneByPhoneNum(String phonenum){
        return repository.findByPhonenum(phonenum).orElse(null);
    }

    public void get_address(String phonenum){
       UserEntity userEntity = repository.findByPhonenum(phonenum).get();

       for(UserAddress userAddress : userEntity.getUserAddressList()){
           AddressEntity addressEntity = userAddress.getAddressEntity();
           System.out.println(addressEntity);
           log.info("{}",addressEntity.getAddress1());
       }
    }

    public List<UserAddressDTO> getUserAddress(LoginDto loginDto) {
        if(loginDto.getType().equals("0")){
          return  userAddressService.find(loginDto.getData());
        }
         return   userAddressService.find(findOneByEmail(loginDto.getData()).getPhonenum());

    }
}
