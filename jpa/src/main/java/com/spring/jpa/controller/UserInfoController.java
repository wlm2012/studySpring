package com.spring.jpa.controller;

import com.spring.jpa.domain.entity.Address;
import com.spring.jpa.domain.entity.UserInfo;
import com.spring.jpa.repository.AddressRepository;
import com.spring.jpa.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController {

    private final UserInfoRepository userInfoRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public UserInfoController(UserInfoRepository userInfoRepository, AddressRepository addressRepository) {
        this.userInfoRepository = userInfoRepository;
        this.addressRepository = addressRepository;
    }

    @RequestMapping("/findAll")
    public List<UserInfo> findAll() {
        List<UserInfo> all = userInfoRepository.findAll();
        System.out.println(all);
        return all;
    }

    @RequestMapping("/findAddress")
    public List<Address> findAddress() {
        List<Address> all = addressRepository.findAll();
        System.out.println("all = " + all);
        return all;
    }
}
