package com.example.capstone.useraddress.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserAddressDTO {
    private String name;
    private String nickname;
    private String phonenum;
    private byte[] profile;
    private String addressNickname;
    private String zipcode;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String address5;

    // standard getters and setters
}