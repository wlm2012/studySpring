package com.study.utils;

import com.study.utils.proxy.CglibImp;
import com.study.utils.proxy.CglibProxy;
import org.junit.jupiter.api.Test;

public class CglibTest {

    @Test
    public void cglib() {
        CglibProxy<CglibImp> cglibProxy = new CglibProxy<>();

        CglibImp cglibImp = cglibProxy.getCglibProxy(new CglibImp());
        Integer print = cglibImp.print("101");
        System.out.println(print);
        System.out.println(cglibImp.random());
    }
}
