package com.spring.webmagic.serviceImp;

import com.spring.webmagic.entity.AVstar;
import com.spring.webmagic.entity.Resources;
import com.spring.webmagic.entityEnum.ResourcesEnum;
import com.spring.webmagic.repository.AVstarRepository;
import com.spring.webmagic.repository.ResourcesReposity;
import com.spring.webmagic.service.ScanStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.util.*;

@Service
public class AVScanStrategy implements ScanStrategy {

    private final AVstarRepository aVstarRepository;
    private final ResourcesReposity resourcesReposity;

    @Autowired
    public AVScanStrategy(AVstarRepository aVstarRepository, ResourcesReposity resourcesReposity) {
        this.aVstarRepository = aVstarRepository;
        this.resourcesReposity = resourcesReposity;
    }

    @Override
    @Transactional
    public void scan(String path) {
        List<AVstar> aVstarList = aVstarRepository.findAll();
        List<Resources> resourcesList = resourcesReposity.findByType(ResourcesEnum.av);

        List<AVstar> aVstarsExist = new ArrayList<>();
        List<Resources> resourcesExist = new ArrayList<>();

        File[] files = new File(path).listFiles();
        assert files != null;
        for (File file : files) {
            Set<AVstar> aVstarSet = new HashSet<>();
            Set<Resources> resourcesSet = new HashSet<>();

            String name = file.getName();
            List<String> nameList = new ArrayList<>();
            if (name.contains(",")) {
                String[] names = name.split(",");
                Collections.addAll(nameList, names);
            } else {
                nameList.add(name);
            }

            for (String n : nameList) {
                String actress = n.replace("\\)", "");
                String[] split = actress.split("\\(");
                Optional<AVstar> first = aVstarList.stream()
                        .filter(a -> {
                            if (a.getName() != null) {
                                for (String s : split) {
                                    if (a.getName().contains(s)) {
                                        return true;
                                    }
                                }
                            }
                            if (a.getChineseName() != null) {
                                for (String s : split) {
                                    if (a.getChineseName().contains(s)) {
                                        return true;
                                    }
                                }
                            }
                            return false;
                        }).findFirst();

                if (first.isPresent()) {
                    AVstar aVstar = first.get();
                    aVstar.setExist(true);
                    aVstarSet.add(aVstar);
                    aVstarsExist.add(aVstar);
                    aVstarRepository.save(aVstar);
                } else {
                    AVstar build = AVstar.builder().name(n).score(70).exist(true).build();
                    aVstarSet.add(build);
                    aVstarList.add(build);
                    aVstarsExist.add(build);
                }
            }

            File[] listFiles = file.listFiles();
            assert listFiles != null;
            for (File listFile : listFiles) {
                Optional<Resources> first = resourcesList.stream()
                        .filter(r -> r.getName().equals(listFile.getName()))
                        .findFirst();

                if (first.isPresent()) {
                    Resources resources = first.get();
                    resources.setExist(true);
                    resourcesSet.add(resources);
                } else {
                    Resources build = Resources.builder().name(listFile.getName()).path(listFile.getPath())
                            .type(ResourcesEnum.av).exist(true).build();
                    resourcesSet.add(build);
                    resourcesList.add(build);
                }
            }
            resourcesExist.addAll(resourcesSet);
            AVstarResourceService.addresources(resourcesSet, aVstarSet);
        }

        resourcesList.stream()
                .filter(r -> r.getId() != null)
                .filter(Resources::isExist)
                .filter(r -> {
                    for (Resources resources : resourcesExist) {
                        if (r.getId().equals(resources.getId())) {
                            return false;
                        }
                    }
                    return true;
                })
                .forEach(r -> r.setExist(false));

        aVstarList.stream()
                .filter(a -> a.getId() != null)
                .filter(AVstar::isExist)
                .filter(a -> {
                            for (AVstar aVstar : aVstarsExist) {
                                if (a.getId().equals(aVstar.getId())) {
                                    return false;
                                }
                            }
                            return true;
                        }
                ).forEach(a -> a.setExist(false));

        resourcesReposity.saveAll(resourcesList);
        aVstarRepository.saveAll(aVstarList);

    }

}
