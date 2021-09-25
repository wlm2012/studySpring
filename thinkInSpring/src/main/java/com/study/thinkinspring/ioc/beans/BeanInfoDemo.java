package com.study.thinkinspring.ioc.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.Arrays;

public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {

        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);



        Arrays.stream(beanInfo.getPropertyDescriptors()).forEach(property -> {
            Class<?> propertyType = property.getPropertyType();
            String propertyName = property.getName();
            if ("age".equals(propertyName)) {
                property.setPropertyEditorClass(StringToInteget.class);
            }
        });

        Arrays.stream(beanInfo.getPropertyDescriptors()).forEach(System.out::println);
    }

    static class StringToInteget extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue(Integer.valueOf(text));
        }
    }
}
