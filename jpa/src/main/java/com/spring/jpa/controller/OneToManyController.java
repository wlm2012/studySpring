package com.spring.jpa.controller;

import com.spring.jpa.common.ServiceException;
import com.spring.jpa.domain.dto.*;
import com.spring.jpa.domain.entity.DogEntity;
import com.spring.jpa.domain.entity.DogOwnerEntity;
import com.spring.jpa.repository.DogOwnerRepository;
import com.spring.jpa.repository.DogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/oneToMany")
@RestController
@RequiredArgsConstructor
public class OneToManyController {

    private final DogOwnerRepository dogOwnerRepository;

    private final DogRepository dogRepository;

    @GetMapping("/queryDogOwner")
    @Transactional(readOnly = true)
    public DogOwnerEntity queryDogOwner(String id) {
        Optional<DogOwnerEntity> dogOwnerEntityOptional = dogOwnerRepository.findById(id);
        if (dogOwnerEntityOptional.isPresent()) {
            DogOwnerEntity dogOwnerEntity = dogOwnerEntityOptional.get();
            System.out.println("dogOwnerEntity.getName() = " + dogOwnerEntity.getName());
            for (DogEntity dogEntity : dogOwnerEntity.getDogEntityList()) {
                System.out.println("dogEntity = " + dogEntity);
            }
            return dogOwnerEntity;
        } else {
            return null;
        }
    }


    @PostMapping("/saveDogs")
    @Transactional
    public void saveDogs(@RequestBody DogsDto dogsDto) {

        Optional<DogOwnerEntity> dogOwnerEntityOptional = dogOwnerRepository.findById(dogsDto.getDogOwnerId());
        DogOwnerEntity dogOwnerEntity = dogOwnerEntityOptional.orElseThrow(() -> new ServiceException("主人不存在"));

        List<DogDto> dogDtoList = dogsDto.getDogDtoList();
        ArrayList<DogEntity> dogEntityList = new ArrayList<>();
        for (DogDto dogDto : dogDtoList) {
            DogEntity dogEntity = DogEntity.fromDogDto(dogDto);
            dogEntity.setDogOwnerEntity(dogOwnerEntity);
            dogEntityList.add(dogEntity);
        }
        dogRepository.saveAll(dogEntityList);
    }



    @PostMapping("/saveDogOwner")
    @Transactional
    public void saveDogOwner(@RequestBody DogOwnerAddDto dogOwnerAddDto) {
        DogOwnerEntity dogOwnerEntity = DogOwnerEntity.fromDogOwnerDto(dogOwnerAddDto);
        dogOwnerRepository.save(dogOwnerEntity);
    }

    @PostMapping("/deleteDogOwner")
    @Transactional
    public void deleteDogOwner(@RequestBody IdDto idDto) {
        dogOwnerRepository.deleteById(idDto.getId());
    }

    @PostMapping("/updateDogOwner")
    @Transactional
    public void updateDogOwner(@RequestBody DogOwnerUpdateDto dogOwnerUpdateDto) {
        Optional<DogOwnerEntity> dogOwnerEntityOptional = dogOwnerRepository.findById(dogOwnerUpdateDto.getId());
        DogOwnerEntity dogOwnerEntity = dogOwnerEntityOptional.orElseThrow(() -> new ServiceException("主人不存在"));
        dogOwnerEntity.updateByDogOwnerUpdateDto(dogOwnerUpdateDto);
        dogOwnerRepository.save(dogOwnerEntity);
    }

    @PostMapping("/updateDog")
    @Transactional
    public void updateDog(@RequestBody DogUpdateDto dogUpdateDto) {
        Optional<DogEntity> dogEntityOptional = dogRepository.findById(dogUpdateDto.getId());
        DogEntity dogEntity = dogEntityOptional.orElseThrow(() -> new ServiceException("the dog is not exist"));
        dogEntity.updateByDogUpdateDto(dogUpdateDto);
        DogOwnerEntity dogOwnerEntity = dogEntity.getDogOwnerEntity();
        dogOwnerEntity.setAge(dogOwnerEntity.getAge() + 10);
    }
}
