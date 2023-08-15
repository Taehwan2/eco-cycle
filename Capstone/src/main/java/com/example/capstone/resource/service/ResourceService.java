package com.example.capstone.resource.service;

import com.example.capstone.resource.db.Resource;
import com.example.capstone.resource.db.ResourceRepository;
import com.example.capstone.resource.db.Resources;
import com.example.capstone.resource.db.ResourcesRepository;
import com.example.capstone.resource.model.Api;
import com.example.capstone.resource.model.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ResourceService  {

    private final ResourceRepository repository;
    private final ResourcesRepository resourcesRepository;

    public void createResource( Resource resource) {

        repository.save(resource);
    }

    public void createResources(List<Resource> resources) {
        repository.saveAll(resources);
    }

    public void createResources1(Resources resources) {
        resourcesRepository.save(resources);
    }
    public Api<List<Resource>> getList(Pageable pageable){

        var list = repository.findAll(pageable);
        var pagination = Pagination.builder().page(list.getNumber())
                .size(list.getSize())
                .cuurentElement(list.getNumberOfElements())
                .totalElemnet(list.getTotalElements())
                .totalpage(list.getTotalPages())
                .build();
        List<Resource> list2 = list.getContent();
        var response = Api.<List<Resource>>builder()
                .body(list2)
                .pagination(pagination)
                .build();

        return response;
    }

    public Api<List<Resources>> getLists(Pageable pageable){

        var list = resourcesRepository.findAll(pageable);
        var pagination = Pagination.builder().page(list.getNumber())
                .size(list.getSize())
                .cuurentElement(list.getNumberOfElements())
                .totalElemnet(list.getTotalElements())
                .totalpage(list.getTotalPages())
                .build();
        List<Resources> list2 = list.getContent();
        var response = Api.<List<Resources>>builder()
                .body(list2)
                .pagination(pagination)
                .build();

        return response;
    }
}
