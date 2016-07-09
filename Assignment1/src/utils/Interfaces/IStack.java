package utils.Interfaces;

public interface IStack<T> {
    public T top();

    public T pop();

    public void push(T element);

    public boolean isEmpty();

    public boolean isFull(); // array

    public int size();

    public String toString();
}
