package utils;

public class ArrayBase <T> {
    public int size = 0;
    public T[] array;

    ArrayBase() {
        this.array = (T[]) new Object[10];
    }

    protected void enlarge() {
        this.array = (T[]) new Object[array.length + 10];
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
}
