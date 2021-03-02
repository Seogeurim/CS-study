package Stack;

public class ArrayStack<E> implements IStack<E> {
    private static final int CAPACITY = 1000;
    private E[] data;
    private int top = -1;

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void push(E e) throws IllegalStateException {
        if (size() == data.length) throw new IllegalStateException("Stack is full");
        data[++top] = e;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        return data[top--];
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return data[top];
    }
}
