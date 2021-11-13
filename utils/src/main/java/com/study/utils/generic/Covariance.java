package com.study.utils.generic;

import com.study.utils.entity.Apple;
import com.study.utils.entity.Fruit;
import com.study.utils.entity.Plate;

public class Covariance {

    public static void test() {
        Plate<? extends Fruit> plate = new Plate<Apple>(new Apple());
/*        plate.set(new Apple());
        plate.set(new Fruit());*/

        Object object = plate.get();
        Fruit fruit = plate.get();
//        Apple apple = plate.get();
    }
}
