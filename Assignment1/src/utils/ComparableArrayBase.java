package utils;

public class ComparableArrayBase<T extends Comparable<T>> extends ArrayBase<T> {

    public void newArray(int new_size) {
        this.array =  (T[]) new Comparable[new_size];
    }
}
