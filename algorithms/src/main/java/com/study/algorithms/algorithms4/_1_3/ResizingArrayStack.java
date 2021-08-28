package com.study.algorithms.algorithms4._1_3;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ResizingArrayStack<Item> implements Iterable<Item> {


    private int n = 0;
    private Item[] items = (Item[]) new Object[1];

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < n; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    public void push(Item item) {
        if (n == items.length && n > 0) {
            resize(items.length * 2);
        }

        items[n++] = item;
    }

    public Item pop() {
        if (n > 0 && n == items.length / 4) {
            resize(items.length / 2);
        }
        Item item = items[n--];
        items[n] = null;
        return item;
    }


    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int i = n;


        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return items[--i];
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }

        @Override
        public void forEachRemaining(Consumer<? super Item> action) {
            Iterator.super.forEachRemaining(action);
        }
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
