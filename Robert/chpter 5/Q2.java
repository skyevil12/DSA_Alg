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

	private static void printPreOrderTreeValue(TreeNode node) {
		if(node == null) {
			return;
		}

		System.out.println(String.valueOf(node.value));
		printPreOrderTreeValue(node.left);
		printPreOrderTreeValue(node.right);
	}
}