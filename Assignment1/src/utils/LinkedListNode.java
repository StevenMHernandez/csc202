package utils;

import java.io.Serializable;

public class LinkedListNode <T> implements Serializable {

    private T element;
    LinkedListNode <T> pointer;

    public LinkedListNode(T element) {
        this.element = element;
        this.pointer = null;
    }

    public LinkedListNode(T element, LinkedListNode <T> pointer) {
        this.element = element;
        this.pointer = pointer;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public LinkedListNode <T> getPointer() {
        return pointer;
    }

    public void setPointer(LinkedListNode <T> pointer) {
        this.pointer = pointer;
    }

    public String toString() {
        return this.element + ((this.pointer != null) ? " " + this.pointer : "");
    }

//    public int compareTo(LinkedListNode node) {
//        return this.element.compareTo(node.element);
//    }
}
