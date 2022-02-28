package com.study.utils.property;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PropertyController {

    @Resource
    private PropertyConfig propertyConfig;

    @RequestMapping("/testPropert")
    public void testPropert() {
        System.out.println(propertyConfig);
    }
}
