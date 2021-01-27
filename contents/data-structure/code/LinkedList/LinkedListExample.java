package LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        System.out.println("==================SLL==================");
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

        System.out.println("==================DLL==================");
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addFirst(10);
        dll.addLast(50);
        System.out.println(dll);
        System.out.println(dll.size());
        System.out.println(dll.first());
        System.out.println(dll.last());
        System.out.println(dll.removeFirst());
        System.out.println(dll);
        System.out.println(dll.removeLast());
        System.out.println(dll);
    }
}

