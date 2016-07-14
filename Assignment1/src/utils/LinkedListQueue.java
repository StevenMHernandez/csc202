package utils;

import Exceptions.EmptyListException;
import utils.Interfaces.IQueue;

public class LinkedListQueue<T> implements IQueue<T> {
    LinkedListNode<T> head;
    LinkedListNode<T> tail;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public void enqueue(T element) {
        LinkedListNode<T> newNode = new LinkedListNode<T>(element, null);

        if (this.isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.setPointer(newNode);
        }

        this.tail = newNode;
    }

    @Override
    public T dequeue() throws Exception {
        if (this.isEmpty()) {
            throw new EmptyListException("No elements left in the Queue");
        }

        LinkedListNode<T> dequeuedNode = this.head;

        this.head = dequeuedNode.getPointer();

        return dequeuedNode.getElement();
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        if (this.head != null) {
            int size = 1;
            LinkedListNode<T> currentNode = this.head;
            while (currentNode.getPointer() != null) {
                currentNode = currentNode.getPointer();
                size++;
            }
            return size;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "LinkedListIndexedList{" +
                "list={" + this.head + "}" +
                '}';
    }
}
