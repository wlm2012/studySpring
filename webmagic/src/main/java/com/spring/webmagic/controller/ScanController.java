package com.spring.webmagic.controller;

import com.spring.webmagic.serviceImp.ScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScanController {

    private final ScanService scanService;

    @Autowired
    public ScanController(ScanService scanService) {
        this.scanService = scanService;
    }

    @RequestMapping("/scan")
    public void scan() {
        scanService.scan();
    }
}
