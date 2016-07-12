package utils;

import Exceptions.EmptyListException;
import utils.Interfaces.IStack;

public class LinkedListStack<T> implements IStack<T> {
    private LinkedListNode<T> top = null;

    @Override
    public T top() throws Exception {
        if (this.isEmpty()) {
            throw new EmptyListException("Cannot top an empty Stack");
        }

        return top.getElement();
    }

    @Override
    public T pop() {
        LinkedListNode<T> current = this.top;
        this.top = current.getPointer();
        return current.getElement();
    }

    @Override
    public void push(T element) {
        this.top = new LinkedListNode<T>(element, this.top);
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        if (this.top != null) {
            int size = 1;
            LinkedListNode<T> currentNode = this.top;
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
                "list={" + this.top + "}" +
                '}';
    }
}
