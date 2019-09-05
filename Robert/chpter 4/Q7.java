1. need to know if node had been went through

/*package whatever //do not write package name here */

import java.io.*;

class GFG {

	public static class MyLinkedList<T> {

		public MyNode<T> head;
		public MyNode<T> tail;

		public void add(T data) {
			MyNode<T> node = new MyNode<>(data);

			if(head == null) {
				head = node;
				tail = node;
				return;
			}

			tail.next = node;
			tail = node;
		}

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
		MyLinkedList<Integer> linkedList = new MyLinkedList<>();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		linkedList.add(6);
		linkedList.add(8);
		System.out.print("A isLoop: "+checkIsLoop(linkedList)+"\n");

		linkedList = new MyLinkedList<>();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		linkedList.add(6);
		linkedList.add(8);
		linkedList.tail.next = linkedList.head.next.next;
		System.out.print("B isLoop: "+checkIsLoop(linkedList)+"\n");
	}

	public static boolean checkIsLoop(MyLinkedList<Integer> linkedList) {
		MyNode<Integer> head = linkedList.head;
		MyNode<Integer> temp = new MyNode<>(-1);
		while(head!=null) {
			if(head.next ==null) {
				return false;
			}

			if(head.next.equals(temp)) {
				return true;
			}

			MyNode<Integer> nextNode = head.next;
			head.next = temp;
			head = nextNode;
		}

		return false;
	}




}