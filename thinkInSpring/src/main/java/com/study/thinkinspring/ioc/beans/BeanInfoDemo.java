package com.study.thinkinspring.ioc.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;

public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {

        BeanInfo beanInfo= Introspector.getBeanInfo(Person.class);

    }
}
