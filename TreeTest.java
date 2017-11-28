import java.util.*;

public class TreeTest {
	public static void main(String... args) {
	
	}
}

interface Position<E> {
	E getElement() throws IllegalStateException;
}

interface Tree<E> extends Iterable<E> {
	Position<E> root();
	Position<E> parent(Position<E> p) throws IllegalArgumentException;
	Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;

	int numChildren(Position<E> p) throws IllegalArgumentException;
	boolean isInternal(Position<E> p) throws IllegalArgumentException;
	boolean isExternal(Position<E> p) throws IllegalArgumentException;
	boolean isRoot(Position<E> p) throws IllegalArgumentException;

	int size();
	boolean isEmpty();
	Iterator<E> iterator();
	Iterable<Position<E>> positions();
}

interface BinaryTree<E> extends Tree<E> {
	Position<E> left(Position<E> p) throws IllegalArgumentException;
	Position<E> right(Position<E> p) throws IllegalArgumentException;
	Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}

abstract class AbstractTree<E> implements Tree<E> {
	public boolean isInternal(Position<E> p) { return numChildren(p) > 0; }
	public boolean isExternal(Position<E> p) { return numChildren(p) == 0; }
	public boolean isRoot(Position<E> p) { return p == root(); }
	public boolean isEmpty() { return size() == 0; }

	public int depth(Position<E> p) {
		if(isRoot(p)) {
			return 0;
		}

		return 1 + depth(parent(p));
	}
}

abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
	public Position<E> sibling(Position<E> p) {
		Position<E> parent = parent(p);
		if(null == parent) {
			return null;
		}
		
		if(p == left(parent)) {
			return right(parent);
		} else {
			return left(parent);
		}
	}
	
	public int numChildren(Position<E> p) {
		int count = 0;
		if(null != left(p)) {
			count++;
		}
		
		if(null != right(p)) {
			count++;
		}
		return count;
	}
	
	public Iterable<Position<E>> children(Position<E> p) {
		List<Position<E>> snapShot = new ArrayList<>(2);
		if(null != left(p)) {
			snapShot.add(left(p));
		}
		
		if(null != right(p)) {
			snapShot.add(right(p));
		}
		return snapShot;
	}
}