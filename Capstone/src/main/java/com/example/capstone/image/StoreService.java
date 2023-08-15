package com.example.capstone.image;

import org.springframework.web.multipart.MultipartFile;

public interface StoreService {
    public String store(MultipartFile file, String phonenum);
}
