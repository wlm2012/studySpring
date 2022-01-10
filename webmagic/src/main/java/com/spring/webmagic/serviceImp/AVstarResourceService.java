package com.spring.webmagic.serviceImp;

import com.spring.webmagic.entity.AVstar;
import com.spring.webmagic.entity.Resources;

import java.util.HashSet;
import java.util.Set;

public class AVstarResourceService {

    public static void addresources(Set<Resources> resourcesSet, Set<AVstar> aVstarSet) {

        for (Resources resource : resourcesSet) {
            Set<AVstar> set = resource.getAVstarSet();
            if (set == null) {
                set = new HashSet<>();
            }
            set.addAll(aVstarSet);
        }

        for (AVstar aVstar : aVstarSet) {
            Set<Resources> set = aVstar.getResourcesSet();
            if (set == null) {
                set = new HashSet<>();
            }
            set.addAll(resourcesSet);
        }
    }
}
