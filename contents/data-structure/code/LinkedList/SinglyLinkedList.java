package LinkedList;

public class SinglyLinkedList<E> implements ILinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SinglyLinkedList() {
        head = tail = null;
        size = 0;
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
    public E first() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    @Override
    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    @Override
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (isEmpty()) tail = head;
        size ++;
    }

    @Override
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) head = newest;
        else tail.setNext(newest);
        tail = newest;
        size ++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null;
        E target = head.getElement();
        head = head.getNext();
        size --;
        if (isEmpty()) tail = null;
        return target;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) return null;
        E target;
        if (head == tail) {
            target = head.getElement();
            head = tail = null;
        } else {
            Node<E> current = head;
            while (current.getNext() != tail) {
                current = current.getNext();
            }
            target = tail.getElement();
            tail = current;
            tail.setNext(null);
        }
        size --;
        return target;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head;
        while (current.getNext() != null) {
            sb.append(current.getElement()).append(", ");
            current = current.getNext();
        }
        sb.append(current.getElement()).append("]");
        return sb.toString();
    }

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node() {
            this(null, null);
        }

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}

