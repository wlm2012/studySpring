package com.spring.webmagic.service;

import com.spring.webmagic.entity.AVstar;
import com.spring.webmagic.repository.AVstarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvService {

    private AVstarRepository Avrepository;

    @Autowired
    public AvService(AVstarRepository repository){
        Avrepository=repository;
    }

    public void test(){

        AVstar avstar = new AVstar();

    }
}
