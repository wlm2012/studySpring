package com.spring.webmagic.serviceImp;

import com.spring.webmagic.entity.AVstar;
import com.spring.webmagic.entity.Resources;

import java.util.Set;

public class AVstarResourceService {

    public static void addresources(Set<Resources> resourcesSet, Set<AVstar> aVstars) {

        for (Resources resource : resourcesSet) {
            resource.setAVstarList(aVstars);
        }

        for (AVstar aVstar : aVstars) {
            aVstar.setResourcesSet(resourcesSet);
        }
    }
}
