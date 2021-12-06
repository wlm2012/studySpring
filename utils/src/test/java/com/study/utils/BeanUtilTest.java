package com.study.utils;

import com.study.utils.BO.Spider;
import com.study.utils.BO._3dmGameSpider;
import com.study.utils.entity.SpiderUpdate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

public class BeanUtilTest {

    @Test
    public void copy() {
        Spider spider = new _3dmGameSpider("1", "2", "3");
        SpiderUpdate spiderUpdate = new SpiderUpdate();
        BeanUtils.copyProperties(spider, spiderUpdate);
        System.out.println(spiderUpdate);
    }
}
