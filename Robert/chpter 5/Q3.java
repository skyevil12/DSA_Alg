/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {


		TreeNode tree = new TreeNode(100);
		tree.left = new TreeNode(50);
		tree.right = new TreeNode(150);
		tree.left.left = new TreeNode(25);
		tree.left.right = new TreeNode(75);
		tree.right.left = new TreeNode(125);
		tree.right.right = new TreeNode(175);
		tree.right.left.left = new TreeNode(110);

		printPreOrderTreeValue(tree);

	}

	private static class TreeNode {

		public int value;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int value) {
			this.value = value;
		}

	}

	private static class Stack<T> {
		StackNode<T> head;

		public void push(T data) {
			if(data == null) {
				return;
			}

			StackNode<T> newNode = new StackNode<>(data);

			if(head == null) {
				head = newNode;
				return;
			}

			newNode.nextNode = head;
			head = newNode;
		}

		public T peek() {
			return head.data;
		}

		public T pop() {
			if(head == null) {
				return null;
			}

			StackNode<T> tempNode = head;
			head = tempNode.nextNode;
			return tempNode.data;
		}

	}

	private static class StackNode<T> {
		public T data;
		public StackNode<T> nextNode;

		public StackNode(T data) {
			this.data = data;
		}
	}

	private static void printPreOrderTreeValue(TreeNode node) {

		Stack<TreeNode> treeNodeStack = new Stack<>();

		TreeNode currentNode = node;
		while(currentNode!=null) {
			System.out.println(String.valueOf(currentNode.value));
			treeNodeStack.push(currentNode.right);
			treeNodeStack.push(currentNode.left);
			currentNode = treeNodeStack.pop();
		}
	}
}