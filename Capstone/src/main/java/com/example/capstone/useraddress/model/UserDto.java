package com.example.capstone.useraddress.model;

import com.example.capstone.address.db.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String phonenum;
    private String name;
    private String email;
    private String password;
    private String birthday;
    private AddressEntity addressEntity;

}