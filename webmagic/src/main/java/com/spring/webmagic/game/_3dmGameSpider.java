package com.spring.webmagic.game;

import com.spring.webmagic.BO.Spider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;


@TargetUrl("https://bbs.3dmgame.com/forum-3402-1.html")
public class _3dmGameSpider extends Spider {

    @ExtractBy(value = "/html/body/div[7]/div[4]/div/div/ul/li[9]/a/span/text()")
    private String content;

    private String name = "零：濡鸦之巫女";

    private String url = "https://bbs.3dmgame.com/forum-3402-1.html";

}

