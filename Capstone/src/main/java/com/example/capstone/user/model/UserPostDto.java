package com.example.capstone.user.model;

import lombok.*;

import javax.persistence.Column;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPostDto {
    private String phonenum;
    private String name;
    private String email;
    private String password;
    private String birthday;
    private String nickname;
    private byte[] profile;
}
