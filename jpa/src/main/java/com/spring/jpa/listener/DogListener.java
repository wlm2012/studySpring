package com.spring.jpa.listener;

import com.spring.jpa.domain.entity.DogAuditEntity;
import com.spring.jpa.domain.entity.DogEntity;
import com.spring.jpa.repository.DogAuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Component
public class DogListener {


    private final DogAuditRepository dogAuditRepository;

    private String name;

    @Autowired
    public DogListener(@Lazy DogAuditRepository dogAuditRepository) {
        this.dogAuditRepository = dogAuditRepository;
    }


    @PrePersist
    @PreUpdate
    public void preUpdate(DogEntity dogEntity) {
        name = dogEntity.getName();
    }

    @PostPersist
    @PostUpdate
    @Transactional
    public void postUpdate(DogEntity dogEntity) {
        if (StringUtils.hasText(name) && !name.equals(dogEntity.getName())) {
            dogAuditRepository.save(DogAuditEntity.builder()
                    .oldName(name)
                    .newName(dogEntity.getName())
                    .build());
        } else {
            dogAuditRepository.save(DogAuditEntity.builder()
                    .newName(name)
                    .build());
        }
    }

}
