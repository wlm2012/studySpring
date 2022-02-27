package com.study.utils.propert;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PropertController {

    @Resource
    private PropertConfig propertConfig;

    @RequestMapping("/testPropert")
    public void testPropert() {
        System.out.println(propertConfig);
    }
}
