package utils;

import utils.Interfaces.IQueue;

public class ArrayQueue<T> extends ArrayBase<T> implements IQueue<T> {

    @Override
    public void enqueue(T element) {
        if (this.isFull()) this.enlarge();

        this.array[this.size] = element;

        this.size++;
    }

    @Override
    public T dequeue() {
        T dequeuedElement = this.array[0];

        // shift array to the left
        for(int i = 0; i <= this.size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }

        this.size--;

        return dequeuedElement;
    }
}