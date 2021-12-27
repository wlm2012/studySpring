package com.study.utils.proxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy<T> implements MethodInterceptor {

    private T t;

    @SuppressWarnings("unchecked")
    public <U extends T> U getCglibProxy(T target) {
        this.t = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(t.getClass());
        enhancer.setCallback(this);
        return (U) enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib begin");
        Object invoke = method.invoke(t, objects);
        System.out.println("cglib end");
        return invoke;
    }
}
