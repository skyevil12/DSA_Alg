/*package whatever //do not write package name here */
// 找Tree Height
// O(n) O(n)?
// Stack memroy?

import java.io.*;

class GFG {
	public static void main (String[] args) {


		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(5);

		System.out.println("tree height: "+calculateTreeHeight(tree));

	}

	private static class TreeNode {

		public int value;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int value) {
			this.value = value;
		}

	}

	private static int calculateTreeHeight(TreeNode node) {
		if(node == null) {
			return 0;
		}

		return 1+Math.max(calculateTreeHeight(node.left),
		                  calculateTreeHeight(node.right));

	}

}