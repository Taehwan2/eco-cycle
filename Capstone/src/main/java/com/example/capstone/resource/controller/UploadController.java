package com.example.capstone.resource.controller;

import com.example.capstone.image.FileSystemStorageService;
import com.example.capstone.resource.RequestResource;
import com.example.capstone.resource.db.Resource;
import com.example.capstone.resource.db.Resources;
import com.example.capstone.resource.db.ResourcesRepository;
import com.example.capstone.resource.model.Api;
import com.example.capstone.resource.model.ResourceRequest;
import com.example.capstone.resource.service.ResourceService;
import com.example.capstone.user.Service.UserService;
import com.example.capstone.user.db.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@RestController
public class UploadController {

private final ResourceService resourceService;

private final UserService userService;
private  final FileSystemStorageService fileSystemStorageService;



//    @PostMapping("/resources3")
//    public void createResourcesw(@RequestParam("images") MultipartFile[] images, @RequestParam("requests") String requestsJson) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        List<ResourceRequest> requestList = objectMapper.readValue(requestsJson, new TypeReference<List<ResourceRequest>>(){});
//        List<Resource> resources= new ArrayList<>();
//
//        if (images.length != requestList.size()) {
//            System.out.println(images.length);
//            System.out.println("requestList.size() = " + requestList.size());
//            throw new IllegalArgumentException("The number of images does not match the number of requests");
//        }
//
//        // Process each request
//        for (int i = 0; i < requestList.size(); i++) {
//            ResourceRequest request = requestList.get(i);
//            String name =userService.findOneByPhoneNum(request.getPhonenum()).getName();
//            MultipartFile image = images[i];
//
//            String imagePath = fileSystemStorageService.store(image,name);
//
//            Resource resource = new Resource(
//                    request.getResourceNum(),
//                    request.getName(),
//                    request.getNum(),
//                    request.getPhonenum(),
//                    request.getAddress(),
//                    imagePath,
//                    Resource.ResourceStates.REGESTERED
//            );
//            resources.add(resource);
//        }
//        resourceService.createResources(resources);
//    }
    @PostMapping("/resources2")
    public void createResources(@RequestParam("images") MultipartFile[] images, @RequestParam("requests") String requestsJson) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<ResourceRequest> requestList = objectMapper.readValue(requestsJson, new TypeReference<List<ResourceRequest>>(){});
        List<Resource> resources= new ArrayList<>();

        if (images.length != requestList.size()) {
            System.out.println(images.length);
            System.out.println("requestList.size() = " + requestList.size());
            throw new IllegalArgumentException("The number of images does not match the number of requests");
        }

        // Process each request
        for (int i = 0; i < requestList.size(); i++) {
            ResourceRequest request = requestList.get(i);
            String name =userService.findOneByPhoneNum(request.getPhonenum()).getName();
            MultipartFile image = images[i];

            String imagePath = fileSystemStorageService.store(image,name);

            Resource resource = new Resource(
                    request.getResourceNum(),
                    request.getName(),
                    request.getNum(),
                    request.getPhonenum(),
                    request.getAddress(),
                    imagePath,
                    Resource.ResourceStates.REGESTERED
            );
            resources.add(resource);
        }
        Resources resources1 = new Resources();
        resources1.setList(resources);
        resourceService.createResources1(resources1);
    }
    @GetMapping("/getResource")
    public Api<List<Resource>> getResourceList(@PageableDefault(page = 0,size = 10) Pageable pageable) {
        return resourceService.getList(pageable);
    }
    @GetMapping("/getResources")
    public Api<List<Resources>> getResourceLists(@PageableDefault(page = 0,size = 10) Pageable pageable) {
        return resourceService.getLists(pageable);
    }



}