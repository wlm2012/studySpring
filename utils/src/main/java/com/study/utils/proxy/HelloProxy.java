package com.study.utils.proxy;

import java.lang.reflect.Proxy;

public class HelloProxy {

    public static void proxy() {
        HelloInterfacce helloProxy = (HelloInterfacce) Proxy.newProxyInstance(HelloImp.class.getClassLoader(),
                HelloImp.class.getInterfaces(), (proxy, method, args) -> {
                    HelloImp helloImp = new HelloImp();
                    if (method.getName().equals("cost")) {
                        int invoke = (int) method.invoke(helloImp, args);
                        System.out.println("proxy: " + (invoke - 10));
                        return invoke - 10;
                    }

                    if (method.getName().equals("print")) {
                        System.out.println("proxy:----------");
                        helloImp.print((String) args[0], (Integer) args[1]);
                    }
                    return null;

                });

        System.out.println(helloProxy.cost("90"));
        helloProxy.print("wlm", 99);
    }
}
