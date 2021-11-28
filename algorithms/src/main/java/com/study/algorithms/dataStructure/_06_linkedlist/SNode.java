package com.study.algorithms.dataStructure._06_linkedlist;

public class SNode<T> {

    private T element;

    private SNode<T> next;

    public void rmByNum() {

    }

    public void rmByValue() {

    }

    public void add(T element) {

    }

    public SNode(T element) {
        this.element = element;
    }

    public SNode(T element, SNode<T> next) {
        this.element = element;
        this.next = next;
    }

    public SNode() {
        this.next = null;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public SNode<T> getNext() {
        return next;
    }

    public void setNext(SNode<T> next) {
        this.next = next;
    }
}
