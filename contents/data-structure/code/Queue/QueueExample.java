package Queue;

public class QueueExample {

    public static void main(String[] args) {
        {
            ArrayQueue<Integer> queue = new ArrayQueue<>(3);

            queue.enqueue(5);
            queue.enqueue(3);

            System.out.println(queue.size());       // 2
            System.out.println(queue.dequeue());    // 5
            System.out.println(queue.isEmpty());    // false
            System.out.println(queue.dequeue());    // 3
            System.out.println(queue.isEmpty());    // true
            System.out.println(queue.dequeue());    // null

            queue.enqueue(7);
            queue.enqueue(9);

            System.out.println(queue.peek());       // 7

            queue.enqueue(4);

            System.out.println(queue.dequeue());    // 7
        }
        {
            LinkedQueue<Integer> queue = new LinkedQueue<>();

            queue.enqueue(5);
            queue.enqueue(3);

            System.out.println(queue.size());       // 2
            System.out.println(queue.dequeue());    // 5
            System.out.println(queue.isEmpty());    // false
            System.out.println(queue.dequeue());    // 3
            System.out.println(queue.isEmpty());    // true
            System.out.println(queue.dequeue());    // null

            queue.enqueue(7);
            queue.enqueue(9);

            System.out.println(queue.peek());       // 7

            queue.enqueue(4);

            System.out.println(queue.dequeue());    // 7
        }
    }
}
