
find data N last from bottom

// Simple Java program to find n'th node from end of linked list
class LinkedList < T > {
    MyLinkedNode < T > head; // head of the list

    public void add(T data) {
        MyLinkedNode < T > newNode = new MyLinkedNode <  > ();
        newNode.data = data;
        if (head == null) {
            head = newNode;
            return;
        }

        addToLast(head, newNode);
    }

    private void addToLast(MyLinkedNode < T > node, MyLinkedNode < T > newNode) {

        if (node.next == null) {
            node.next = newNode;
        } else {
            addToLast(node.next, newNode);
        }

    }

    /* Function to get the nth node from the last of a
    linked list */
    void printNthFromLast(int n) {
        if (head == null) {
            System.out.println("empty");
            return;
        }

        if (n <= 0) {
            System.out.println("Not valid N: " + n);
            return;
        }

        MyLinkedNode < T > forwardNode = head;
        for (int i = 0; i < n - 1; i++) {
            if (forwardNode.next == null) {
                System.out.println("less than " + n);
                return;
            }

            forwardNode = forwardNode.next;
        }

        MyLinkedNode < T > behideNode = head;
        behideNode = findNodeFromBottom(forwardNode, behideNode);
        System.out.println(behideNode.data);
    }

    private MyLinkedNode < T > findNodeFromBottom(MyLinkedNode < T > forwardNode, MyLinkedNode < T > behideNode) {
        if (forwardNode.next == null) {
            return behideNode;
        } else {
            return findNodeFromBottom(forwardNode.next, behideNode.next);
        }
    }

    public static class MyLinkedNode < T > {

        public T data;
        public MyLinkedNode < T > next;
    }

    /*Drier program to test above methods */
    public static void main(String[]args) {
        LinkedList < Integer > llist = new LinkedList <  > ();
        llist.add(20);
        llist.add(4);
        llist.add(15);
        llist.add(35);

        llist.printNthFromLast(4);
        llist.printNthFromLast(1);
        llist.printNthFromLast(0);
        llist.printNthFromLast(5);

    }
} // This code is contributed by Rajat Mishra
