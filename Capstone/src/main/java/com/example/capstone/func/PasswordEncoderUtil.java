package com.example.capstone.func;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//    private static final PasswordEncoder passwordEncoder =
//        PasswordEncoderFactories.createDelegatingPasswordEncoder();

    public static boolean match(String rawPassword, String newPassword) {
        System.out.println(rawPassword);
        System.out.println(newPassword);
        return passwordEncoder.matches(rawPassword, newPassword);
    }

    public static String encode(String rawPassword) {

        return passwordEncoder.encode(rawPassword);
    }

}