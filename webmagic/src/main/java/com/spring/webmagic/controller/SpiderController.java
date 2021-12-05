package com.spring.webmagic.controller;


import com.spring.webmagic.game._3dmGameSpider;
import com.spring.webmagic.pipeline.DatasourcePipeline;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;

import javax.annotation.Resource;

@RestController
public class SpiderController {

    @Resource
    private DatasourcePipeline datasourcePipeline;

    @RequestMapping("/spider")
    public void test(){
        OOSpider.create(Site.me().setSleepTime(1000),
                        datasourcePipeline,
                        _3dmGameSpider.class)
                .addUrl("https://bbs.3dmgame.com/forum-3402-1.html")
                .thread(1)
                .run();
    }
}
