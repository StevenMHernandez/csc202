package utils.Interfaces;

public interface IOrderedListComparable<E extends Comparable<E>> {
    public void add(E t);

    public void remove(int i);

    public boolean contains(E e);

    public boolean isEmpty();

    public int size();

    public Comparable<E> get(int i);

    public String toString();

    public void reset();

    public Comparable<E> getNext();
}
