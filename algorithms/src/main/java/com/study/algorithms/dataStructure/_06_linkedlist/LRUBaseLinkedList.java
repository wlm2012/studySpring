package com.study.algorithms.dataStructure._06_linkedlist;


/*
 * 淘汰最少使用的缓存
 * 1) 增加新节点的时候，检查数据是否已经存在，如果存在则移到最上方，
 * 如果不存在，如果队列已满，则删除末尾的节点，将新数据插入头部
 * 否则直接插入头部
 * 2) 利用哨兵简化程序
 *
 *
 * */
public class LRUBaseLinkedList<T> {

    /**
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 3;

    /**
     * 头结点
     */
    private SNode<T> headNode;

    /**
     * 链表长度（实际节点数量）
     */
    private Integer length;

    /**
     * 链表容量(最大容量)
     */
    private Integer capacity;


    public LRUBaseLinkedList() {
        this(0);
    }

    public LRUBaseLinkedList(int capacity) {
        this.headNode = new SNode<>();
        this.capacity = capacity == 0 ? DEFAULT_CAPACITY : capacity;
        this.length = 0;
    }

    public void add(T data) {
        SNode<T> sNode = findPreNode(data);
        if (sNode != null) {
            deleteElemOptim(sNode);
        } else if (length >= capacity) {
            deleteElemAtEnd();
        }
        intsertElemAtBegin(data);
    }

    private SNode<T> findPreNode(T data) {
        SNode<T> node = headNode;
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    private void deleteElemAtEnd() {
        SNode<T> ptr = headNode;
        if (headNode.getNext() == null) {
            headNode.setElement(null);
            return;
        }
        while (ptr.getNext().getNext() != null) {
            ptr = ptr.getNext();
        }
        ptr.getNext().setElement(null);
        ptr.setNext(null);
        length--;
    }

    private void deleteElemOptim(SNode<T> sNode) {
        SNode<T> temp = sNode.getNext();
        sNode.setNext(temp.getNext());
        temp = null;
        length--;
    }

    private void intsertElemAtBegin(T data) {
        SNode<T> temp = headNode.getNext();
        headNode.setNext(new SNode<>(data, temp));
        length++;
    }

    public void printAll() {
        SNode<T> sNode = headNode.getNext();
        while (sNode != null) {
            System.out.println(sNode.getElement());
            sNode = sNode.getNext();
        }
        System.out.println("");

    }


}
