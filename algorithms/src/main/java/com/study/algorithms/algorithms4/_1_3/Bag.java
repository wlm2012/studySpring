package com.study.algorithms.algorithms4._1_3;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Bag<Item> implements Iterable<Item> {

    private int N = 1;
    private Item[] items = (Item[]) new Object[1];

    public Bag() {

    }


    public void add(Item item) {

    }

    public boolean isEmpty() {

        return false;
    }

    public int size() {
        return N;
    }


    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Item> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Item> spliterator() {
        return Iterable.super.spliterator();
    }
}
