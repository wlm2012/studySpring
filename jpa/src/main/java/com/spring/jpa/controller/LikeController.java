package com.spring.jpa.controller;

import com.spring.jpa.domain.entity.DoctorEntity;
import com.spring.jpa.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class LikeController {

    private final DoctorRepository doctorRepository;

    @GetMapping("/like")
    public List<DoctorEntity> like(String data) {
        return doctorRepository.like(data);
    }


}
