package com.study.moocwiki.utils;

import cn.hutool.core.convert.Convert;
import org.springframework.data.domain.PageRequest;

public class PageUtils {

    public static PageRequest start() {
        return PageRequest.of(Convert.toInt(ServletUtils.getParameter("pageNum"), 0),
                Convert.toInt(ServletUtils.getParameter("pageSize"), 10));
    }
}
