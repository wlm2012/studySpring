package com.spring.jpa.controller;

import com.spring.jpa.common.ServiceException;
import com.spring.jpa.domain.dto.SignAddDto;
import com.spring.jpa.domain.entity.DoctorEntity;
import com.spring.jpa.domain.entity.FamilyEntity;
import com.spring.jpa.repository.DoctorRepository;
import com.spring.jpa.repository.FamilyRepository;
import com.spring.jpa.repository.SignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DoctorController {

    private final SignRepository signRepository;

    private final FamilyRepository familyRepository;

    private final DoctorRepository doctorRepository;


    @RequestMapping("/addSign")
    public void addSign(SignAddDto signAddDto) {
        FamilyEntity familyEntity = familyRepository.findById(signAddDto.getFamilyId())
                .orElseThrow(() -> new ServiceException("家人不存在"));

        DoctorEntity doctorEntity = doctorRepository.findById(signAddDto.getDoctorId())
                .orElseThrow(() -> new ServiceException("this doctor is not exist"));
    }
}
