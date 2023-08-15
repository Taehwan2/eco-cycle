package com.example.capstone.resource;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestResource {
        private MultipartFile image;
        private String name;
        private String num;

}
