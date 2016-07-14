package utils;

import Exceptions.ElementAlreadyExistsException;
import Exceptions.EmptyListException;
import utils.Interfaces.IIndexedList;

public class ArrayIndexedList<T> extends ArrayBase<T> implements IIndexedList<T> {

    @Override
    public void add(T t) throws Exception {

        if (this.contains(t)) {
            throw new ElementAlreadyExistsException("Element already exists in the list");
        }

        if (this.isFull()) {
            this.enlarge();
        }

        this.array[this.size] = t;
        this.size++;
    }

    @Override
    public void set(T t, int i) {
        this.array[i] = t;
    }

    @Override
    public void remove(int index) throws Exception {
        if (this.isEmpty()) {
            throw new EmptyListException("Cannot remove from an empty list.");
        }

        for (int i = index; i <= this.size; i++) {
            this.array[i] = this.array[i + 1];
        }

        this.array[this.size] = null;
        this.size--;
    }

    @Override
    public int indexOf(T t) {
        if (this.size() == 0) return -1;

        int count = 0;

        while (count < this.size) {
            if (this.array[count] == t) {
                return count;
            } else {
                count++;
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
        return this.size() == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T get(int i) {
        return this.array[i];
    }

    @Override
    public void reset() {
        this.newArray(); // may not be necessary??
        this.size = 0;
    }

    @Override
    public T getNext() {
        return null;
    }
}
