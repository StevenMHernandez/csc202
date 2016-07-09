package utils;

public class LinkedListNode <T> {

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
}
