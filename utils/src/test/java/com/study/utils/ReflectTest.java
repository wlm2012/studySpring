package com.study.utils;

import com.study.utils.entity.Person;
import com.study.utils.reflect.ReflectClass;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;


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

    @Test
    public void printField() {
        ReflectClass.printField(Person.class);
    }


    @Test
    public void ResourceTest() throws ClassNotFoundException {
        ReflectClass.ResourceTest();
    }

    @Test
    public void copyArray() {
        Integer[] ints = new Integer[]{1, 2, 3};
        Integer[] integers = ReflectClass.copyArray(ints, 2);
        assert integers != null;
        for (Integer i : integers) {
            System.out.println(i);
        }
    }

    @Test
    public void GenericTest() throws NoSuchFieldException {
        ReflectClass.GenericTest();
    }


}
