package com.example.capstone.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserAuthorityService {

    @Value("${mail.address.admin}")
    private String adminMailAddress;

    private  final List<String> ADMIN_ROLES_STRING=List.of("ADMIN","USER");
    private final List<String> USER_ROLES_STRING = List.of("USER");

    public List<String> createAuthorites(String email){
        if(email.equals(adminMailAddress)){
            return ADMIN_ROLES_STRING;
        }
        return  USER_ROLES_STRING;
    }
}






