
wrong removeHead Method

public static class MyLinkedList < T > {
    private MyLinkedNode < T > head;
    private MyLinkedNode < T > tail;
	
	public void removeHead(){
		if(head == null){
			return;
		}
		
		MyLinedNode<T> tempNode = head;
		head = head.next;
		tempNode.next = null;
	}

    public void add(T data) {
        MyLinkedNode < T > newNode = new MyLinkedNode <  > ();
        newNode.data = data;
        if (head == null) {
            head = newNode;
            return;
        }

        if (tail == null) {
            tail = newNode;
            head.next = tail;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void addAfter(T after, T data) {
        if (head == null) {
            return;
        }

        addAfter(head, after, data);
    }

    private void addAfter(MyLinkedNode < T > node, T after, T data) {
        if (node == null) {
            return;
        }

        if (node.data.equals(after)) {
            MyLinkedNode < T > newNode = new MyLinkedNode <  > ();
            newNode.data = data;

            MyLinkedNode < T > tempNode = node.next;
            node.next = newNode;
            newNode.next = tempNode;

            if (tempNode == null) {
                tail = newNode;
            }

        } else {
            addAfter(node.next, after, data);
        }
    }

    public boolean remove(T data) {
        if (head == null) {
            return false;
        }

        if (head.data.equals(data)) {
            MyLinkedNode < T > tempNode = head.next;
            head = tempNode;

            if (head == tail) {
                tail = null;
            }
            return true;
        }

        return remove(head, data);
    }

    private boolean remove(MyLinkedNode < T > node, T data) {
        if (node.next == null) {
            return false;
        }

        if (node.next.data.equals(data)) {
            MyLinkedNode < T > tempNode = node.next.next;
            node.next = tempNode;

            if (tempNode == null) {
                tail = node;
            }
            return true;

        } else {
            return remove(node.next, data);
        }

    }

    public String toString() {
        if (head == null) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        builder = appendData(builder, head);
        return builder.toString();
    }

    private StringBuilder appendData(StringBuilder builder, MyLinkedNode < T > node) {
        builder.append(String.valueOf(node.data));
        if (node.next == null) {
            return builder;

        } else {
            builder.append(",");
            return appendData(builder, node.next);
        }
    }

    public String getHeadTail() {
        String result = "";
        if (head != null) {
            result += String.valueOf(head.data);
        }

        if (tail != null) {
            result += ",";
            result += String.valueOf(tail.data);
        }

        return result;
    }

    public static class MyLinkedNode < T > {

        public T data;
        public MyLinkedNode < T > next;
    }

}
