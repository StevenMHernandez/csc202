package utils;

import utils.Interfaces.IStack;

public class ArrayStack<T> extends ArrayBase<T> implements IStack<T> {

    @Override
    public T top() {
        if (this.size == 0) {
            return null;
        }
        return this.array[this.size - 1];
    }

    @Override
    public T pop() {
        T poppedElement = this.top();

        this.size--;

        return poppedElement;
    }

    @Override
    public void push(T element) {
        if (this.isFull()) this.enlarge();

        this.array[this.size] = element;

        this.size++;
    }
}
