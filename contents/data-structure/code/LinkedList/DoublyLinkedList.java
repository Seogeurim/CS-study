package LinkedList;

public class DoublyLinkedList<E> implements ILinkedList<E> {
    private Node<E> header;
    private Node<E> trailer;
    private int size;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
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
        return header.getNext().getElement();
    }

    @Override
    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();
    }

    @Override
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    @Override
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(header.getNext());
    }

    @Override
    public E removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");
        DoublyLinkedList.Node<E> current = header.getNext();
        while (current.getNext() != trailer) {
            sb.append(current.getElement()).append(", ");
            current = current.getNext();
        }
        sb.append(current.getElement()).append("]");
        return sb.toString();
    }

    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size ++;
    }

    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size --;
        return node.getElement();
    }

    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node() {
            this(null, null, null);
        }

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}