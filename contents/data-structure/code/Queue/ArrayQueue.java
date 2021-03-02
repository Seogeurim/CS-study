package Queue;

public class ArrayQueue<E> implements IQueue<E> {
    private static final int CAPACITY = 1000;
    private E[] data;
    private int front = 0;
    private int size = 0;

    public ArrayQueue() {
        this(CAPACITY);
    }

    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (size == data.length) throw new IllegalStateException("Queue is full");
        int avail = (front + size) % data.length;
        data[avail] = e;
        size ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        E target = data[front];
        data[front] = null; // dereference to help garbage collection
        front = (front + 1) % data.length;
        size --;
        return target;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return data[front];
    }
}
