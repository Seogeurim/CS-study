package Stack;

public interface IStack<E> {
    public int size();
    public boolean isEmpty();

    public void push(E e);
    public E pop();
    public E peek();
}
