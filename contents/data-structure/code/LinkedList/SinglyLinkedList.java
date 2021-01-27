package LinkedList;

public class SinglyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private long size;

    public SinglyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public long size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (isEmpty()) tail = head;
        size ++;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e, null);
        if (isEmpty()) head = newNode;
        else tail.setNext(newNode);
        tail = newNode;
        size ++;
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        E target = head.getElement();
        head = head.getNext();
        size --;
        if (size == 0) tail = null;
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

        public Node() { }

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setElement(E newElement) {
            this.element = newElement;
        }

        public void setNext(Node<E> newNext) {
            this.next = newNext;
        }
    }
}

