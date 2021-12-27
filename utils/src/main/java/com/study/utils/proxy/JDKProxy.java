package com.study.utils.proxy;

import java.lang.reflect.Proxy;

public class JDKProxy {

    public static void proxy() {
        JDKInterfacce JDKProxy = (JDKInterfacce) Proxy.newProxyInstance(JDKImp.class.getClassLoader(),
                JDKImp.class.getInterfaces(), (proxy, method, args) -> {
                    System.out.println("jdkProxy begin");
                    System.out.println("method.getName() " + method.getName());
                    JDKImp helloImp = new JDKImp();
                    // 反射 + 有返回值
                    if (method.getName().equals("cost")) {
                        int invoke = (int) method.invoke(helloImp, args);
                        System.out.println("proxy: " + (invoke - 10));
                        System.out.println("jdkProxy end");
                        return invoke - 10;
                    }

                    // 普通调用 没有返回值 是否可以这样赋值？
                    if (method.getName().equals("print")) {
                        helloImp.print((String) args[0], (Integer) args[1]);
                        System.out.println("jdkProxy end");
                        return null;
                    }
                    Object invoke = method.invoke(helloImp, args);
                    System.out.println("jdkProxy end");
                    return invoke;

                });

        System.out.println(JDKProxy.cost("90"));
        JDKProxy.print("wlm", 99);
        System.out.println(JDKProxy.random());
    }
}
