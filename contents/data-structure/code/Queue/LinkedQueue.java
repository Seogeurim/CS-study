package Queue;

import LinkedList.SinglyLinkedList;

public class LinkedQueue<E> implements IQueue<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();

    public LinkedQueue() {}

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.first();
    }
}
