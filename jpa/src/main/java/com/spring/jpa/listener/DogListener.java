package com.spring.jpa.listener;

import com.spring.jpa.domain.entity.DogAuditEntity;
import com.spring.jpa.domain.entity.DogEntity;
import com.spring.jpa.repository.DogAuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Component
public class DogListener {


    private DogAuditRepository dogAuditRepository;


    @Autowired
    public DogListener(@Lazy DogAuditRepository dogAuditRepository) {
        this.dogAuditRepository = dogAuditRepository;
    }

    private final Map<String, String> map = new HashMap<>();

    public DogListener() {

    }


    @PostLoad
    public void preUpdate(DogEntity dogEntity) {
        map.put(dogEntity.getId(), dogEntity.getName());
    }

    @PostPersist
    @PostUpdate
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void postUpdate(DogEntity dogEntity) {
        String oldName = map.get(dogEntity.getId());

        if (StringUtils.hasText(oldName) && !oldName.equals(dogEntity.getName())) {
            dogAuditRepository.save(DogAuditEntity.builder()
                    .dogId(dogEntity.getId())
                    .oldName(oldName)
                    .newName(dogEntity.getName())
                    .build());
            map.remove(dogEntity.getId());
        } else {
            dogAuditRepository.save(DogAuditEntity.builder()
                    .dogId(dogEntity.getId())
                    .newName(dogEntity.getName())
                    .build());
        }
    }

}
