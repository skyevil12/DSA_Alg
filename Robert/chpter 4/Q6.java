1. 是否是child
2. 是否是next(check previous)
3. 是否上述兩種都不是(往回找是誰的next)
4. 最後一個節點的處理


/*package whatever //do not write package name here */

import java.io.*;

class GFG {

	public static class MyLinkedList<T> {

		public MyNode<T> head;
		public MyNode<T> tail;


		public void add(MyNode<T> node) {
			if(head == null) {
				head = node;
				tail = node;
				return;
			}

			tail.next = node;
			tail = node;
		}
	}

	public static class MyNode<T> {
		public MyNode<T> previous;
		public MyNode<T> next;
		public MyNode<T> down;

		public T data;

		public MyNode(T data) {
			this.data = data;
		}

		public void addNext(MyNode<T> node) {
			next = node;
			node.previous = this;
		}

		public void addDown(MyNode<T> node) {
			down = node;
		}
	}



	public static void main (String[] args) {

		MyNode<Integer> head=new MyNode<>(1);
		head.addNext(new MyNode<Integer>(2));
		head.next.addNext(new MyNode<Integer>(3));
		head.next.next.addNext(new MyNode<Integer>(4));
		head.next.addDown(new MyNode<Integer>(7));
		head.next.down.addDown(new MyNode<Integer>(9));
		head.next.down.down.addDown(new MyNode<Integer>(14));
		head.next.down.down.down.addDown(new MyNode<Integer>(15));
		head.next.down.down.down.down.addNext(new MyNode<Integer>(23));
		head.next.down.down.down.down.next.addDown(new MyNode<Integer>(24));
		head.next.down.addNext(new MyNode<Integer>(8));
		head.next.down.next.addDown(new MyNode<Integer>(16));
		head.next.down.next.down.addDown(new MyNode<Integer>(17));
		head.next.down.next.down.down.addNext(new MyNode<Integer>(18));
		head.next.down.next.down.down.next.addNext(new MyNode<Integer>(19));
		head.next.down.next.down.down.next.next.addNext(new MyNode<Integer>(20));
		head.next.down.next.down.down.next.next.next.addDown(new MyNode<Integer>(21));
		head.next.down.next.addNext(new MyNode<Integer>(10));
		head.next.down.next.next.addDown(new MyNode<Integer>(11));
		head.next.down.next.next.addNext(new MyNode<Integer>(12));

		head = flattenList(head);
		printFlattenNodes(head);
		head = unflattenList(head);
		head = flattenList(head);
		printFlattenNodes(head);
	}


	private static MyNode<Integer> flattenList(MyNode<Integer> head) {
		appendNode(head,head);

		return head;
	}

	private static MyNode<Integer> appendNode(MyNode<Integer> tailNode,MyNode<Integer> nextNode) {
		MyNode<Integer> downNode = nextNode.down;
		MyNode<Integer> rightNode = nextNode.next;

		if(downNode!=null) {
			tailNode.next = downNode;
			tailNode =  appendNode(tailNode.next,downNode);
		}

		if(rightNode!=null) {
			tailNode.next = rightNode;
			tailNode = appendNode(tailNode.next,rightNode);
		}

		return tailNode;
	}

	public static void printFlattenNodes(MyNode<Integer> head) {
		MyNode<Integer> curr=head;
		String result = "";
		while(curr!=null) {
			result+=curr.data + ",";
			curr = curr.next;
		}
		System.out.print(result+"\n");
	}

	public static MyNode<Integer> unflattenList(MyNode<Integer> head) {
		restoreNode(head,head.next);
		return head;
	}

	private  static MyNode<Integer> restoreNode( MyNode<Integer> node,MyNode<Integer> nextNode) {
		if(nextNode == null) {
			return node;
		}

		MyNode<Integer> lastNode=nextNode;

		if(node.down == lastNode) {
			node.next = null;
			lastNode = restoreNode(nextNode,nextNode.next);
		}

		if(lastNode.previous ==node) {
			node.next = lastNode;
			lastNode = restoreNode(lastNode,lastNode.next);
		}

		if(lastNode.next!=null && lastNode == nextNode) {
			node.next = null;
		}

		return lastNode;
	}




}