// Java code for stack implementation

Stack Implementation

import java.io. * ;
import java.util. * ;

class Test{
    public static class MyStack < T > {
        private StackNode < T > head;

        public MyStack() {}

        public void push(T data) {
            StackNode < T > newNode = new StackNode <  > ();
            newNode.data = data;

            if (head == null) {
                head = newNode;
                return;
            }

            StackNode < T > tempNode = head;
            head = newNode;
            newNode.next = tempNode;
        }

        public T pop() {
            if (head == null) {
                return null;
            }

            T data = head.data;
            head = head.next;
            return data;
        }

        public T peek() {
            if (head == null) {
                return null;
            }

            return head.data;
        }

        public int search(T data) {
            return search(head, data, 1);
        }

        private int search(StackNode node, T data, int index) {
            if (node == null) {
                return -1;
            }

            if (node.data.equals(data)) {
                return index;

            } else {
                return search(node.next, data, ++index);
            }
        }

    }

    public static class StackNode < T > {
        public StackNode < T > next;
        public T data;
    }

    // Pushing element on the top of the stack
    static void stack_push(MyStack < Integer > stack) {
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
    }

    // Popping element from the top of the stack
    static void stack_pop(MyStack < Integer > stack) {
        System.out.println("Pop :");

        for (int i = 0; i < 5; i++) {
            Integer y = (Integer)stack.pop();
            System.out.println(y);
        }
    }

    // Displaying element on the top of the stack
    static void stack_peek(MyStack < Integer > stack) {
        Integer element = (Integer)stack.peek();
        System.out.println("Element on stack top : " + element);
    }

    // Searching element in the stack
    static void stack_search(MyStack < Integer > stack, int element) {
        Integer pos = (Integer)stack.search(element);

        if (pos == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element is found at position " + pos);
    }

    public static void main(String[]args) {
        MyStack < Integer > stack = new MyStack < Integer > ();

        stack_push(stack);
        stack_pop(stack);
        stack_push(stack);
        stack_peek(stack);
        stack_search(stack, 2);
        stack_search(stack, 6);
    }
}
