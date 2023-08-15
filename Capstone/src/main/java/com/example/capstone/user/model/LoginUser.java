package com.example.capstone.user.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginUser {
    private String type;
    private String userid;
    private String userpw;
}
