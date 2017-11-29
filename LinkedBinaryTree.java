import java.util.*;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
	protected static class Node<E> implements Position<E> {
		private E element;
		private Node<E> parent;
		private Node<E> left;
		private Node<E> right;
		
		public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
			element = e;
			parent = above;
			left = leftChild;
			right = rightChild;
		}
		
		public E getElement() {
			return element;
		}
		
		public Node<E> getParent() {
			return parent;
		}
		
		public Node<E> getLeft() {
			return left;
		}
		
		public Node<E> getRight() {
			return right;
		}
		
		public void setElement(E e) {
			element = e;
		}
		
		public void setParent(Node<E> parentNode) {
			parent = parentNode;
		}
		
		public void setLeft(Node<E> leftChild) {
			left = leftChild;
		}
		
		public void setRight(Node<E> rightChild) {
			right = rightChild;
		}
	}
	protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
		return new Node(e, parent, left, right);
	}
	
	protected Node<E> root = null;
	private int size = 0;
	
	public LinkedBinaryTree() {
	}
	
	protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if(!(p instanceof Node)) {
			throw new IllegalArgumentException("Not valid position type");
		}
		
		Node<E> node = (Node) p;
		
		if(node == node.getParent()) {
			throw new IllegalArgumentException("p is no longer in the tree");
		}
		
		return node;
	}
	
	public int size() {
		return size;
	}
	
	public Node<E> root() {
		return root;
	}
	
	public Node<E> parent(Position<E> p) {
		Node<E> node = validate(p);
		return node.getParent();
	}
	
	public Node<E> left(Position<E> p) {
		Node<E> node = validate(p);
		return node.getLeft();
	}
	
	public Node<E> right(Position<E> p) {
		Node<E> node = validate(p);
		return node.getRight();
	}
	
	public Position<E> addRoot(E e) throws IllegalStateException {
		if(!isEmpty()) {
			throw new IllegalStateException("Tree is not empty");
		}
		
		root = createNode(e, null, null, null);
		size = 1;
		return root;
	}
	
	public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> parent = validate(p);
		if(null != parent.getLeft()) {
			throw new IllegalArgumentException("p already has a left child");
		}
		
		Node<E> newNode = createNode(e, parent, null, null);
		parent.setLeft(newNode);
		size++;
		return newNode;
	}
	
	public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> parent = validate(p);
		if(null != parent.getRight()) {
			throw new IllegalArgumentException("p already has a right child");
		}
		
		Node<E> newNode = createNode(e, parent, null, null);
		parent.setRight(newNode);
		size++;
		return newNode;
	}
	
	public E set(Position<E> p, E e)  throws IllegalArgumentException {
		Node<E> node = validate(p);
		E temp = node.getElement();
		node.setElement(e);
		return temp;
	}
	
	public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
		Node<E> node = validate(p);
		if(isInternal(p)) {
			throw new IllegalArgumentException("p must be a leaf");
		}
		
		size += (t1.size() + t2.size());
		
		if(!t1.isEmpty()) {
			t1.root.setParent(node);
			node.setLeft(t1.root);
			t1.root = null;
			t1.size = 0;
		}
		
		if(!t2.isEmpty()) {
			t2.root.setParent(node);
			node.setRight(t2.root);
			t2.root = null;
			t2.size = 0;
		}
	}

	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		if(2 == numChildren(p)) {
			throw new IllegalArgumentException("p has two children");
		}
		
		Node<E> child = (null != node.getLeft() ? node.getLeft() : node.getRight());
		if(null != child) {
			child.setParent(node.getParent());
		}
		
		if(root == node) {
			root = child;
		} else {
			Node<E> parent = node.getParent();
			if(node == parent.getLeft()) {
				parent.setLeft(child);
			} else {
				parent.setRight(child);
			}
		}
		
		size--;
		
		E temp = node.getElement();
		node.setElement(null);
		node.setLeft(null);
		node.setRight(null);
		node.setParent(node);
		return temp;
	}
}