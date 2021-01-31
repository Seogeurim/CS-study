package LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        System.out.println("==================Singly Linked List==================");
        ILinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.addFirst(3);
        sll.addLast(10);
        sll.addFirst(2);
        sll.addLast(12);
        System.out.println(sll);
        System.out.println("size : " + sll.size());
        System.out.println("first : " + sll.first());
        System.out.println("last : " + sll.last());
        System.out.println("removeFirst : " + sll.removeFirst());
        System.out.println(sll);
        System.out.println("removeLast : " + sll.removeLast());
        System.out.println(sll);
        System.out.println("removeFirst : " + sll.removeFirst());
        System.out.println(sll);
        System.out.println("removeLast : " + sll.removeLast());
        System.out.println(sll);
        System.out.println("size : " + sll.size());

        System.out.println("==================Doubly Linked List==================");
        ILinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.addFirst(3);
        dll.addLast(10);
        dll.addFirst(2);
        dll.addLast(12);
        System.out.println(dll);
        System.out.println("size : " + dll.size());
        System.out.println("first : " + dll.first());
        System.out.println("last : " + dll.last());
        System.out.println("removeFirst : " + dll.removeFirst());
        System.out.println(dll);
        System.out.println("removeLast : " + dll.removeLast());
        System.out.println(dll);
        System.out.println("removeFirst : " + dll.removeFirst());
        System.out.println(dll);
        System.out.println("removeLast : " + dll.removeLast());
        System.out.println(dll);
        System.out.println("size : " + dll.size());
    }
}

