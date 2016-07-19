package utils;

import Exceptions.ElementAlreadyExistsException;
import Exceptions.EmptyListException;
import utils.Interfaces.IIndexedList;

import java.io.Serializable;

public class LinkedListIndexedList<T> implements IIndexedList<T>, Serializable {
    private LinkedListNode<T> first = null;
    private int length = 0;

    @Override
    public void add(T t) throws Exception {
        if (this.contains(t)) {
            throw new ElementAlreadyExistsException("Element already exists in the list");
        }

        LinkedListNode<T> newNode = new LinkedListNode<T>(t, null);
        if (this.first == null) {
            first = newNode;
        } else {
            this.getNthNode(this.length - 1).setPointer(newNode);
        }

        this.length++;
    }

    @Override
    public void set(int i, T t) {
        if (i > length) {
            throw new IndexOutOfBoundsException();
        }
        LinkedListNode<T> replacedNode = this.getNthNode(i);

        LinkedListNode<T> newNode = new LinkedListNode<T>(t, replacedNode.getPointer());

        this.getNthNode(i - 1).setPointer(newNode);
    }

    @Override
    public void remove(int i) throws Exception {
        if (this.isEmpty()) {
            throw new EmptyListException("Cannot remove from an empty list.");
        }
        if (i > this.length - 1) {
            throw new IndexOutOfBoundsException();
        }

        LinkedListNode<T> removedNode = this.getNthNode(i);

        this.getNthNode(i - 1).setPointer(removedNode.getPointer());

        this.length--;
    }

    @Override
    public int indexOf(T t) {
        if (this.size() == 0) return -1;

        int count = 0;

        LinkedListNode<T> node = this.first;
        //for each node
        while (node.getPointer() != null) {
            if (node.getElement().equals(t)) {
                return count;
            } else {
                count++;
                node = node.getPointer();
            }
        }

        return -1;
    }

    @Override
    public boolean contains(T t) {
        return this.indexOf(t) >= 0;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public T get(int i) {
        return this.getNthNode(i).getElement();
    }

    @Override
    public void reset() {
        this.first = null;
        this.length = 0;
    }

    @Override
    public T getNext() {
        return null;
    }

    private LinkedListNode<T> getNthNode(int i) throws NullPointerException {
        if (i > this.length - 1) {
            throw new IndexOutOfBoundsException();
        }
        int count = 0;
        LinkedListNode<T> node = this.first;
        while (count < i && node != null) {
            node = node.getPointer();
            count++;
        }
        if (node == null) {
            throw new NullPointerException();
        }
        return node;
    }

    @Override
    public String toString() {
        return "LinkedListIndexedList{" +
                "list={" + first + "}" +
                ", length=" + length +
                '}';
    }
}
