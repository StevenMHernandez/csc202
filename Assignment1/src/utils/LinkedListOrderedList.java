package utils;

import Exceptions.ElementAlreadyExistsException;
import Exceptions.EmptyListException;
import utils.Interfaces.IOrderedList;

public class LinkedListOrderedList<T extends Comparable<T>> implements IOrderedList<T> {
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
            if (this.first.getElement().compareTo(t) < 0) {
                LinkedListNode<T> node = this.first;

                boolean complete = false;

                do {
                    if (node.getElement().compareTo(t) < 0) {
                        if (node.getPointer() == null) {
                            node.setPointer(newNode);
                            complete = true;
                        } else if (node.getPointer().getElement().compareTo(t) > 0) {
                            LinkedListNode<T> afterNode = node.getPointer();
                            node.setPointer(newNode);
                            newNode.setPointer(afterNode);
                            complete = true;
                        }
                    }
                    node = node.getPointer();
                } while (!complete);
            } else {
                newNode.setPointer(this.first);
                this.first = newNode;
            }
        }

        this.length++;
    }

    @Override
    public void remove(int i) throws Exception {
        if (this.isEmpty()) {
            throw new EmptyListException("Cannot remove from an empty list.");
        }

        LinkedListNode<T> removedNode = this.getNthNode(i);

        this.getNthNode(i - 1).setPointer(removedNode.getPointer());

        this.length--;
    }

    public int indexOf(T t) {
        if (this.size() == 0) return -1;

        int count = 0;

        LinkedListNode<T> node = this.first;
        //for each node
        while (node != null) {
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

    private LinkedListNode<T> getNthNode(int i) {
        int count = 0;
        LinkedListNode<T> node = this.first;
        while (count < i) {
            node = node.getPointer();
            count++;
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
