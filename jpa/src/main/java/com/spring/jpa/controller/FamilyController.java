package com.spring.jpa.controller;

import com.spring.jpa.common.ServiceException;
import com.spring.jpa.domain.entity.FamilyEntity;
import com.spring.jpa.domain.entity.User;
import com.spring.jpa.repository.FamilyRepository;
import com.spring.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/family")
public class FamilyController {

    private final FamilyRepository familyRepository;

    private final UserRepository userRepository;

    @RequestMapping("/add")
    @Transactional
    public void add() {
        User user = userRepository.findById("1").orElseThrow(() -> new ServiceException("1"));
        FamilyEntity family = FamilyEntity.builder()
                .name("wlm")
                .user(user)
                .build();

        familyRepository.save(family);
    }

    @Transactional
    @RequestMapping("/remove/{id}")
    public void remove(@PathVariable String id) {
        familyRepository.deleteById(id);
    }


    @Transactional
    @RequestMapping("/removeOne/{id}")
    public void removeOne(@PathVariable String id) {
        User user = userRepository.findById("1").orElseThrow(() -> new ServiceException("1"));
        Set<FamilyEntity> familyEntities = user.getFamilyEntities();
        Iterator<FamilyEntity> iterator = familyEntities.iterator();
        while (iterator.hasNext()){
            FamilyEntity familyEntity = iterator.next();
            if (familyEntity.getId().equals(id)){
                iterator.remove();
            }
        }
        System.out.println("familyEntities.size() = " + familyEntities.size());
    }




}
