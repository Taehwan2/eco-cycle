package com.example.capstone.model;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
public class BaseEntity {
    @CreatedDate
    @Column(name = "created_at",updatable = true)
    private LocalDateTime createdAt;

    @LastModifiedBy
    @Column(name = "updated_At",updatable = false)
    private LocalDateTime updatedAt;

}
