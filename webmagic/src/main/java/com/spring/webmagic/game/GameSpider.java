package com.spring.webmagic.game;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

@TargetUrl("https://bbs.3dmgame.com/forum-3402-1.html")
public class GameSpider {

    @ExtractBy(value = "/html/body/div[7]/div[4]/div/div/ul/li[9]/a/span/text()")
    private String mod;

    public static void main(String[] args) {
        OOSpider.create(Site.me().setSleepTime(1000),
                        new ConsolePageModelPipeline(),
                        GameSpider.class)
                .addUrl("https://bbs.3dmgame.com/forum-3402-1.html")
                .thread(1)
                .run();

    }
}

