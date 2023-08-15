package com.example.capstone.resource.db;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResourcesRepository extends MongoRepository<Resources,Long> {
    Resources save(Resources resources);

    Page<Resources> findAll(Pageable pageable);
}
