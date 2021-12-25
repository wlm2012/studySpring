package com.study.utils;

import com.study.utils.reflect.ReflectClass;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;


public class ReflectTest {

    @Test
    public void test() {
        ReflectClass.test();
    }

    @Test
    public void testClass() throws ClassNotFoundException {
        ReflectClass.testClass();
    }

    @Test
    public void testClassLoader() throws ClassNotFoundException {
        ReflectClass.testClassLoader();
    }

    @Test
    public void testConstructor() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        ReflectClass.testConstructor();
    }

    @Test
    public void testMethod() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        ReflectClass.testMethod();
    }

    @Test
    public void testField() throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        ReflectClass.testField();
    }
}
