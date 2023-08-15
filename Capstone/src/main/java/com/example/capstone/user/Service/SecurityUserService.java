package com.example.capstone.user.Service;

import com.example.capstone.address.db.AddressEntity;
import com.example.capstone.config.UserAuthorityService;
import com.example.capstone.user.db.UserEntity;
import com.example.capstone.user.db.UserRepository;
import com.example.capstone.useraddress.db.UserAddress;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@Slf4j
@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class SecurityUserService {
    private final UserRepository repository;
    private final UserAuthorityService authorityUtils;

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
    public void save(UserEntity userEntity){
        List<String> roles = authorityUtils.createAuthorites(userEntity.getEmail());
        userEntity.setRoles(roles);
        repository.save(userEntity);

    }

}
