class ArrayStack<E> implements Stack<E> {
	private static final int SIZE = 1000;
	private E[] mElementArray;
	private int mIndex = -1;
	
	ArrayStack() {
		this(SIZE);
	}
	
	ArrayStack(int capacity) {
		mElementArray = (E[])new Object[capacity];
	}

	public E pop() {
		if(isEmpty()) {
			return null;
		}
	
		E popElement = mElementArray[mIndex];
		mElementArray[mIndex] = null;		
		mIndex--;
		return popElement;
	}
	
	public void push(E element) throws FullCapacityException {
		if(mIndex >= SIZE) {
			System.out.println("FullCapacityException!");
			throw new FullCapacityException();
		}
		
		mElementArray[++mIndex] = element;
	}
	
	public boolean isEmpty() {
		return mIndex == -1;
	}
	
	public int size() {
		return mIndex + 1;
	}
	
	public E top() {
		if(isEmpty()) {
			return null;
		}
	
		return mElementArray[mIndex];
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();		
		for(E e: mElementArray) {
			if(null != e) {
				sb.append(e).append(",");
			}
		}
		return sb.toString();
	}
	
	public static void main(String... args) {
		ArrayStack as = new ArrayStack();
		as.push(1);
		as.push(2);
		as.push(3);
		as.push(4);
		//as.pop();
		
		System.out.println(as);
	}
}

interface Stack<E> {
	E pop();
	
	void push(E element);
	
	boolean isEmpty();
	
	int size();
	
	E top();
}

class FullCapacityException extends RuntimeException {
}


