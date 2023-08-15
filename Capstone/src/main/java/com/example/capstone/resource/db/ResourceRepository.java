package com.example.capstone.resource.db;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ResourceRepository extends MongoRepository<Resource,Long> {
    void save(List<Resource> list);


    @Override
    Page<Resource> findAll(Pageable pageable);

}
