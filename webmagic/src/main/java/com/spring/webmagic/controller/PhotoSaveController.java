package com.spring.webmagic.controller;

import com.spring.webmagic.entity.AVstar;
import com.spring.webmagic.repository.AVstarRepository;
import com.study.utils.fileUtil.FilesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

@RestController
public class PhotoSaveController {

    private AVstarRepository repository;

    @Autowired
    public PhotoSaveController(AVstarRepository aVstarRepository) {
        repository = aVstarRepository;
    }


    @Transactional
    @RequestMapping("/save")
    public void save() throws IOException {
        Optional<AVstar> aVstar = repository.findById(1L);
        if (aVstar.isPresent()) {
            String path = "C:\\Users\\wlm\\Desktop\\微信截图_20220105202215.png";
            byte[] bytes = FilesUtils.readFileToByte(path);
            AVstar aVstar1 = aVstar.get();
            aVstar1.setPhoto(bytes);
            System.out.println(aVstar1.getName());
        }
    }

    @RequestMapping("/get")
    public void get() throws IOException {
        Optional<AVstar> aVstar = repository.findById(1L);
        if (aVstar.isPresent()) {
            String path = "C:\\Users\\wlm\\Desktop\\av.png";
            FilesUtils.createFile(path, aVstar.get().getPhoto());
            System.out.println(aVstar.get().getName());
        }
    }



}
