package utils;

import java.util.Arrays;

public class ArrayBase<T> {
    public int size = 0;
    public T[] array;

    ArrayBase() {
        this.newArray();
    }

    protected void enlarge() {
        T[] old = this.array;

        this.array = (T[]) new Object[array.length + 10];

        for (int i = 0; i <= old.length; i++) {
            this.array[i] = old[i];
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.array.length;
    }

    public int size() {
        return this.size;
    }

    protected void newArray() {
        this.array = (T[]) new Object[10];
    }

    @Override
    public String toString() {
        return "ArrayBase{" +
                "size=" + size +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
