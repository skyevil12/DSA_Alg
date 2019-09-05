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

		convertBSTToHeap(tree);
	}

	private static class TreeNode {

		public int value;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int value) {
			this.value = value;
		}

	}

	private static void convertBSTToHeap(TreeNode node) {

		int count = Treversal(node);
		TreeNode[] nodeArray =new TreeNode[count];
		fillNodeArray(0,node,nodeArray);
		nodeArray = sortNodeArray(nodeArray);
		createHeap(nodeArray);
		printPreOrderTreeValue(nodeArray[0]);

	}

	private static int Treversal(TreeNode node) {
		if(node == null) {
			return 0;
		}

		int leftCount = Treversal(node.left);
		int rightCount = Treversal(node.right);
		return 1+leftCount+rightCount;
	}

	private static int fillNodeArray(int i,TreeNode node,TreeNode[] nodeArray) {
		if(node==null) {
			return i;
		}

		nodeArray[i] = node;
		if(node.left!=null)
			i = fillNodeArray(++i,node.left,nodeArray);

		if(node.right!=null)
			i = fillNodeArray(++i,node.right,nodeArray);

		return i;
	}

	private static TreeNode[] sortNodeArray(TreeNode[] nodeArray) {
		for(int i =0; i<nodeArray.length; i++) {
			TreeNode sortNode = nodeArray[i];
			for(int j = i+1; j<nodeArray.length; j++) {
				TreeNode compareNode = nodeArray[j];
				if (sortNode==null||compareNode==null) break;


				if(sortNode.value>compareNode.value) {
					nodeArray[j-1] = compareNode;
					nodeArray[j] = sortNode;
				}
			}
		}

		return nodeArray;
	}

	private static void createHeap(TreeNode[] nodeArray ) {
		for(int i=0; i<nodeArray.length; i++) {
			if(2*i+1<nodeArray.length) {
				nodeArray[i].left = nodeArray[2*i+1];
			} else {
				nodeArray[i].left = null;
			}

			if(2*i+2 <nodeArray.length) {
				nodeArray[i].right = nodeArray[2*i+2];
			} else {
				nodeArray[i].right = null;
			}
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