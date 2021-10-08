package com.study.thinkinspring.ioc.scope;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ScopeController {

    //先按照名称匹配，找不到的话，按照类型匹配。如果设置了name的值，如果找不到，则不再按照类型匹配
    //@Component标注产生bean，beanName为类名（如果首字母为大写，改为小写）
    @Resource
    private ScopeService scopeService1;

    @RequestMapping("/add")
    public void add() {
        //如果本身的bean为单例，即使注入的bean为多例，也不会再次获取，因为只有在初始化bean的时候才会注入bean，不会再次获取
        System.out.println(scopeService1);
        scopeService1.add();
    }
}
