package com.example.capstone.resource.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceRequest {
    private String resourceNum;

    private  String name;

    private int num;

    private String phonenum;

    private String address;

    private MultipartFile image;

}
