package LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.addLast(10);
        sll.addFirst(5);
        sll.addFirst(3);
        sll.addLast(12);
        System.out.println(sll);
        System.out.println(sll.size());
        System.out.println(sll.first());
        System.out.println(sll.last());
        System.out.println(sll.removeFirst());
        System.out.println(sll);
    }
}

