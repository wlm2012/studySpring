package com.study.algorithms._1_3;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Queue<Item> implements Iterable<Item> {

    public Queue() {
    }

    public void enqueue(Item item) {
    }

    public Item dequeue() {
        return null;
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
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
