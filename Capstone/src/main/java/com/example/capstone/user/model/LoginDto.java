package com.example.capstone.user.model;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginDto {
    private String type;
    private String data;
    private String userpw;
}
