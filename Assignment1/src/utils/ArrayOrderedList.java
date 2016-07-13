package utils;

import utils.Interfaces.IOrderedList;

public class ArrayOrderedList<T extends Comparable<T>> extends ArrayBase<T> implements IOrderedList<T> {

    @Override
    public void add(T t) {
        if (this.isFull()) {
            this.enlarge();
        }

        if (this.size != 0) {
            int count = 0;

            // find where to place the item
            if (this.array[count].compareTo(t) < 0) {
                count++;

                boolean complete = false;

                do {
                    if (this.array[count].compareTo(t) < 0) {
                        if (this.array[count] == null) {
                            this.array[count + 1] = t;
                            complete = true;
                        } else if (this.array[count].compareTo(t) > 0) {
                            for (int i = count; i <= this.size; i++) {
                                this.array[i] = this.array[i + 1];
                            }
                            this.array[count] = t;
                            complete = true;
                        }
                    }
                    count++;
                } while (!complete);
            } else {
                for (int i = 0; i <= this.size; i++) {
                    this.array[i] = this.array[i + 1];
                }
                this.array[0] = t;
            }
            System.out.println("other");
        } else {
            System.out.println("okok");
            this.array[0] = t;
        }

        this.size++;
        System.out.println(this.size);
    }

    @Override
    public void remove(int index) {
        for (int i = index; i <= this.size; i++) {
            this.array[i] = this.array[i + 1];
        }

        this.array[this.size] = null;
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
    public T get(int i) {
        return this.array[i];
    }

    @Override
    public void reset() {
        this.newArray();
    }

    @Override
    public T getNext() {
        return null;
    }

}
