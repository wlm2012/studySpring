package com.spring.webmagic.serviceImp;

import com.spring.webmagic.entity.AVstar;
import com.spring.webmagic.repository.AVstarRepository;
import com.spring.webmagic.repository.ResourcesReposity;
import com.spring.webmagic.service.ScanStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AVScanStrategy implements ScanStrategy {

    private AVstarRepository aVstarRepository;
    private ResourcesReposity resourcesReposity;

    @Autowired
    public AVScanStrategy(AVstarRepository aVstarRepository, ResourcesReposity resourcesReposity) {
        this.aVstarRepository = aVstarRepository;
        this.resourcesReposity = resourcesReposity;
    }

    @Override
    @Transactional
    public void scan(String path) {
        List<AVstar> aVstars = aVstarRepository.findAll();

        File[] files = new File(path).listFiles();
        assert files != null;
        for (File file : files) {
            String name = file.getName();
            List<String> nameList = new ArrayList<>();
            if (name.contains(",")) {
                String[] names = name.split(",");
                Collections.addAll(nameList, names);
            } else {
                nameList.add(name);
            }

        }
    }

}
