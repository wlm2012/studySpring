package com.study.utils.annotation;

@CustomClassAnnotation("fruit")
public class Fruit {
    @FruitColor(color = FruitColor.Color.RED)
    private String color;
}
