class ArrayDeque<E> implements Deque<E> {
	private static final int SIZE = 100;
	private E[] mElementArray;
	private int mStartIndex;
	private int mEndIndex;
	private int mValidSize;
	
	ArrayDeque() {
		this(SIZE);
	}
	
	ArrayDeque(int capacity) {
		mElementArray = (E[])new Object[capacity];		
	}
	
	public int size() {
		return mValidSize;
	}
	
	public boolean isEmpty() {
		return 0 == mValidSize;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(E e: mElementArray) {
			if(null != e) {
				sb.append(e).append(",");
			}
		}
		sb.append("-- startIndex --").append(mStartIndex)
		  .append("-- endIndex --").append(mEndIndex);
		return sb.toString();
	}
	
	public E first() {
		return mElementArray[mStartIndex];
	}
	
	public E last() {
		return mElementArray[mEndIndex];
	}
	
	public void addFirst(E e) {
		if(mValidSize >= SIZE) {
			throw new FullCapacityException();
		}
		
		mStartIndex--;
		if(mStartIndex < 0) {
			mStartIndex = (mStartIndex + SIZE) % SIZE;
		}
		
		mElementArray[mStartIndex] = e;
		mValidSize++;
	}
	
	public void addLast(E e) {
		if(mValidSize >= SIZE) {
			throw new FullCapacityException();
		}
		mElementArray[mEndIndex] = e;
		mEndIndex++;
		mValidSize++;
		
		if(mEndIndex >= SIZE) {
			mEndIndex = mEndIndex%SIZE;
		}
	}
	
	public E removeFirst() {
		if(isEmpty()) {
			throw new EmptyException();
		}
		
		E element = mElementArray[mStartIndex];
		mElementArray[mStartIndex] = null;
		mStartIndex++;
		mValidSize--;
		
		if(mStartIndex >= SIZE) {
			mStartIndex = mStartIndex%SIZE;
		}
		
		return element;
	}
	
	public E removeLast() {
		if(isEmpty()) {
			throw new EmptyException();
		}
		
		E element = mElementArray[mEndIndex];
		mElementArray[mEndIndex] = null;
		
		mEndIndex--;
		mValidSize--;
		if(mEndIndex < 0) {
			mEndIndex = (mEndIndex + SIZE) % SIZE;
		}
		
		return element;
	}
	
	public static void main(String... args) {
		ArrayDeque queue = new ArrayDeque();
		for(int i = 0; i < 10; i++) {		
			queue.addLast(i);
		}
		
		System.out.println(queue);
		
		for(int i = 0; i < 5; i++) {		
			queue.removeFirst();
		}
		
		System.out.println(queue);
		
		for(int i = 0; i < 5; i++) {		
			queue.addFirst(i);
		}
		
		System.out.println(queue);
		
		for(int i = 0; i < 5; i++) {		
			queue.removeLast();
		}
		
		System.out.println(queue);
	}
}

interface Deque<E> {
	int size();
	
	boolean isEmpty();
	
	E first();
	
	E last();
	
	void addFirst(E e);
	
	void addLast(E e);
	
	E removeFirst();
	
	E removeLast();
}