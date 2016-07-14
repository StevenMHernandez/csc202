package utils;

import Exceptions.ElementAlreadyExistsException;
import Exceptions.EmptyListException;
import utils.Interfaces.IOrderedListComparable;

public class ArrayOrderedList<T extends Comparable<T>> extends ComparableArrayBase<T> implements IOrderedListComparable<T> {

    @Override
    public void add(T t) throws Exception {
        if (this.contains(t)) {
            throw new ElementAlreadyExistsException("Element already exists in the list");
        }

        if (this.isFull() || this.array.length == this.size + 1) {
            this.enlarge();
        }

        if (this.array[0] == null) { // if nothing
            this.array[0] = t;
        } else {
            if (this.array[0].compareTo(t) < 0) {
                int count = 0;

                boolean complete = false;

                do {
                    if (this.array[count].compareTo(t) < 0) {
                        if (this.array[count + 1] == null) {
                            this.array[count + 1] = t;
                            complete = true;
                        } else if (this.array[count + 1].compareTo(t) > 0) {
                            for (int i = count; i <= this.size; i++) {
                                this.array[i + 1] = this.array[i];
                            }

                            this.array[count] = t;
                            complete = true;
                        }
                    }
                    count++;
                } while (!complete);
            } else {
                for (int i = this.size; i >= 1; i--) {
                    this.array[i] = this.array[i - 1];
                }
                this.array[0] = t;
            }
        }

        this.size++;
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

    public int indexOf(T t) {
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
    public Comparable<T> get(int i) {
        return this.array[i];
    }

    @Override
    public void reset() {
        this.newArray();
        this.size = 0;
    }

    @Override
    public T getNext() {
        return null;
    }

}
