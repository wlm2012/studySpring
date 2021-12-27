package com.study.utils.annotation;

import java.lang.reflect.Field;

public class AnnotationClass {

    public static void reflectTest() {
        Class<Fruit> fruitClass = Fruit.class;
        if (fruitClass.isAnnotationPresent(CustomClassAnnotation.class)) {
            CustomClassAnnotation annotation = fruitClass.getAnnotation(CustomClassAnnotation.class);
            System.out.println(annotation.value());
            Field[] fields = fruitClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(FruitColor.class)) {
                    FruitColor fieldAnnotation = field.getAnnotation(FruitColor.class);
                    System.out.println(fieldAnnotation.annotationType());
                    System.out.println(fieldAnnotation.color());
                }
            }
        }
    }
}
