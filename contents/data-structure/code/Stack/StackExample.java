package Stack;

public class StackExample {

    public static void main(String[] args) {
        {
            ArrayStack<Integer> stack = new ArrayStack<>();

            stack.push(5);
            stack.push(3);

            System.out.println(stack.size());      // 2
            System.out.println(stack.pop());       // 3
            System.out.println(stack.isEmpty());   // false
            System.out.println(stack.pop());       // 5
            System.out.println(stack.isEmpty());   // true
            System.out.println(stack.pop());       // null

            stack.push(7);
            stack.push(9);

            System.out.println(stack.peek());      // 9

            stack.push(4);

            System.out.println(stack.size());      // 3
            System.out.println(stack.pop());       // 4

            stack.push(6);
            stack.push(8);

            System.out.println(stack.pop());       // 8
        }
        {
            LinkedStack<Integer> stack = new LinkedStack<>();

            stack.push(5);
            stack.push(3);

            System.out.println(stack.size());      // 2
            System.out.println(stack.pop());       // 3
            System.out.println(stack.isEmpty());   // false
            System.out.println(stack.pop());       // 5
            System.out.println(stack.isEmpty());   // true
            System.out.println(stack.pop());       // null

            stack.push(7);
            stack.push(9);

            System.out.println(stack.peek());      // 9

            stack.push(4);

            System.out.println(stack.size());      // 3
            System.out.println(stack.pop());       // 4

            stack.push(6);
            stack.push(8);

            System.out.println(stack.pop());       // 8
        }
    }
}
