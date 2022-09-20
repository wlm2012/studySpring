package com.spring.jpa.listener;

import com.spring.jpa.domain.entity.DogAuditEntity;
import com.spring.jpa.domain.entity.DogEntity;
import com.spring.jpa.repository.DogAuditRepository;
import com.spring.jpa.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.persistence.PreUpdate;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Component
public class DogListener {


    private DogAuditRepository dogAuditRepository;

    private DogRepository dogRepository;


    @Autowired
    public DogListener(@Lazy DogAuditRepository dogAuditRepository, @Lazy DogRepository dogRepository) {
        this.dogAuditRepository = dogAuditRepository;
        this.dogRepository = dogRepository;
    }


    public DogListener() {

    }


    @PreUpdate
    public void preUpdate(DogEntity dogEntity) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        System.out.println("request.getRequestURI() = " + request.getRequestURI());
        Optional<DogEntity> dogEntityOptional = dogRepository.findById(dogEntity.getId());
        if (dogEntityOptional.isPresent()) {
            DogEntity dog = dogEntityOptional.get();
            dogAuditRepository.save(DogAuditEntity.builder()
                    .dogId(dog.getId())
                    .oldName(dog.getName())
                    .newName(dogEntity.getName())
                    .build());
        }
    }


}
