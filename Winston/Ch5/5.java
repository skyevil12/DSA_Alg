//Binary tree to heap
//Binary search tree to min heap, inorder traverse to queue element, assign elements in preorder

import java.util.ArrayDeque;
import java.util.Queue;

// Data structure to store a Binary Tree node
class Node
{
	int key;
	Node left, right;

	Node(int key) {
		this.key = key;
	}
};

class Main
{
	// Recursive function to insert an key into BST
	public static Node insert(Node root, int key)
	{
		// if the root is null, create a new node an return it
		if (root == null) {
			return new Node(key);
		}

		// if given key is less than the root node, recur for left subtree
		if (key < root.key) {
			root.left = insert(root.left, key);
		}
		// if given key is more than the root node, recur for right subtree
		else {
			root.right = insert(root.right, key);
		}

		return root;
	}

	// Helper function to perform level order traversal of binary tree
	public static void printLevelOrderTraversal(Node root)
	{
		// base case: empty tree
		if (root == null) {
			return;
		}

		Queue<Node> q = new ArrayDeque<>();
		q.add(root);

		while (!q.isEmpty())
		{
			int n = q.size();
			while (n-- > 0)
			{
				Node front = q.poll();
				System.out.print(front.key + " ");

				if (front.left != null) {
					q.add(front.left);
				}

				if (front.right != null) {
					q.add(front.right);
				}
			}

			System.out.println();
		}
	}

	// Function to perform inorder traversal of a binary tree and
	// push all nodes in a queue (in encountered order)
	public static void inorder(Node root, Queue<Integer> keys)
	{
		if(null == root) {
		    return;
		}
		
		inorder(root.left, keys);
		keys.offer(root.key);
		inorder(root.right, keys);
	}

	// Function to perform preorder traversal of the binary tree
	// Assign each encountered node with next key from the queue
	public static void preorder(Node root, Queue<Integer> keys)
	{
		if(null == root) {
		    return;
		}
		
		root.key = keys.poll();
		preorder(root.left, keys);
		preorder(root.right, keys);
	}

	// Function to convert a BST to a min heap
	public static void convert(Node root)
	{
		Queue<Integer> queue = new ArrayDeque<Integer>();
		
		inorder(root, queue);
		
		preorder(root, queue);
	}

	public static void main(String[] args)
	{
		Node root = null;

		/* Construct below bst
	               5
	             /   \
	            /     \
	           3       8
	          / \     / \
	         /   \   /   \
	        2     4 6    10
		*/

		int[] keys = { 5, 3, 2, 4, 8, 6, 10 };
		for (int key: keys) {
			root = insert(root, key);
		}

		convert(root);
		printLevelOrderTraversal(root);
	}
}

