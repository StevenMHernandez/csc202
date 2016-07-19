package utils;

public class ArrayBase<T> {
    public int size = 0;
    public T[] array;

    ArrayBase() {
        this.newArray();
    }

    protected void enlarge() {
        T[] old = this.array;

        this.newArray(this.array.length + 10);

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
        this.newArray(10);
    }

    protected void newArray( int new_size) {
        this.array = (T[]) new Object[new_size];
    }

    @Override
    public String toString() {
        String val = "ArrayBase{" +
                "array={";

        for (int i = 0; i < this.size(); i++) {
            val += this.array[i];
            if (i != this.size() - 1) val += " ";
        }

        val += "}, size=" + size + "}";

        return val;
    }
}
