package com.kgh.web.global.domain.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.ZonedDateTime;

@MappedSuperclass
public class BaseEntity {

    @Column(name = "created_at")
    protected ZonedDateTime createdAt;

    @Column(name = "updated_at")
    protected ZonedDateTime updatedAt;
    @Column(name = "created_by")
    protected Long createdBy;

    @Column(name = "updated_by")
    protected Long updatedBy;

    @PrePersist
    protected void prePersist() {
        createdBy = 1L;
        updatedBy = 1L;
        createdAt = ZonedDateTime.now();
        updatedAt = ZonedDateTime.now();
    }

    @PreUpdate
    protected void preUpdate(){
        updatedBy = 1L;
        updatedAt = ZonedDateTime.now();
    }
}
