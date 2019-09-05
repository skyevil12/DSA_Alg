/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {


		TreeNode tree = new TreeNode(20);
		tree.left = new TreeNode(8);
		tree.right = new TreeNode(22);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(12);
		tree.left.right.left = new TreeNode(10);
		tree.left.right.right = new TreeNode(14);
		
		System.out.println(String.valueOf(findLowestAnsenstor(tree,new TreeNode(4),new TreeNode(14))));

	}

	private static class TreeNode {

		public int value;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int value) {
			this.value = value;
		}

	}

	private static int findLowestAnsenstor(TreeNode testNode,TreeNode node1,TreeNode node2) {
		if(node1.value >testNode.value && node2.value>testNode.value) {
			return findLowestAnsenstor(root.right,node1,node2);

		} else if (node1.value<testNode.value &&node2.value<testNode.value) {
			return findLowestAnsenstor(root.left,node1,node2);

		} else {
			return testNode.value;
		}
	}
}