/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {


		TreeNode tree = new TreeNode(8);
		tree.right = new TreeNode(9);
		tree.left = new TreeNode(6);
		tree.left.right = new TreeNode(7);
		tree.left.left = new TreeNode(4);
		tree.left.left.right = new TreeNode(5);
		tree.left.left.left = new TreeNode(2);
		tree.left.left.left.right = new TreeNode(3);
		tree.left.left.left.left = new TreeNode(1);

		balanceBST(tree);
	}

	private static class TreeNode {

		public int value;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int value) {
			this.value = value;
		}

		public void rotateLeft(TreeNode newParent) {
			left = newParent.right;
			newParent.right = this;
		}

	}

	private static void balanceBST(TreeNode node) {
		List<TreeNode> nodeList = new ArrayList<>();
		inOrderTree(node,nodeList);
		System.out.println("");
		for(TreeNode mNode:nodeList) {
			System.out.println("result: "+String.valueOf(mNode.value));
		}

		TreeNode newNode = balanceBST(0,nodeList.size()-1,nodeList);

		printBFS(newNode);

	}

	private static void inOrderTree(TreeNode node,List<TreeNode>nodeList) {
		System.out.print("inOrder: "+String.valueOf(node.value)+",");


		if(node.left!=null)
			inOrderTree(node.left,nodeList);
		nodeList.add(node);
		System.out.println("");
		System.out.print("node add: "+String.valueOf(node.value)+",");
		if(node.right!=null)
			inOrderTree(node.right,nodeList);
	}

	private static TreeNode balanceBST(int start,int end,List<TreeNode> nodeList) {
		int count = end - start+1;
		int middle = count/2;

		if(count<=3) {
			TreeNode node = nodeList.get(start+middle);
			TreeNode leftNode = nodeList.get(start);
			TreeNode rightNode = nodeList.get(end);

			if(!leftNode.equals(node)) {
				node.left = leftNode;
				leftNode.left = null;
				leftNode.right = null;
			} else {
				node.left = null;
			}

			if(!rightNode.equals(node)) {
				node.right = rightNode;
				rightNode.left = null;
				rightNode.right = null;
			} else {
				node.right = null;
			}

			return node;
		}

		System.out.println(String.valueOf(start + middle));
		TreeNode node = nodeList.get(start+middle);
		node.left = balanceBST(start,start+middle-1,nodeList);
		node.right = balanceBST(start+middle+1,end,nodeList);

		return node;
	}

	private static void printBFS(TreeNode... nodes) {
		for(TreeNode node:nodes) {
			if(node!=null)
				System.out.println("BFS: "+node.value);
		}

		for(TreeNode node:nodes) {
			if(node!=null)
				printBFS(node.left,node.right);
		}
	}

}