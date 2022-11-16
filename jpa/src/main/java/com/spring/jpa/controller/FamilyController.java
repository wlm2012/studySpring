package com.spring.jpa.controller;

import com.spring.jpa.common.ServiceException;
import com.spring.jpa.domain.entity.FamilyEntity;
import com.spring.jpa.domain.entity.User;
import com.spring.jpa.repository.FamilyRepository;
import com.spring.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
