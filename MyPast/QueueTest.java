//Use circular array
//Access & Remove from head and insert in tail
class ArrayQueue<E> implements Queue<E> {
	private static final int SIZE = 100;
	private E[] mElementArray;
	private int mStartIndex;
	private int mEndIndex;
	private int mValidSize;
	
	ArrayQueue() {
		this(SIZE);
	}
	
	ArrayQueue(int capacity) {
		mElementArray = (E[])new Object[capacity];		
	}
	
	public int size() {
		return mValidSize;
	}
	
	public boolean isEmpty() {
		return 0 == mValidSize;
	}
	
	public E first() {
		return mElementArray[mStartIndex];
	}
	
	public void enque(E e) throws FullCapacityException {
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
	
	public E deque() throws EmptyException {
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
	
	public static void main(String... args) {
		ArrayQueue queue = new ArrayQueue();
		for(int i = 0; i < 10; i++) {		
			queue.enque(i);
		}
		
		System.out.println(queue);
		
		for(int i = 0; i < 5; i++) {		
			queue.deque();
		}
		
		System.out.println(queue);
		
		for(int i = 0; i < 5; i++) {		
			queue.enque(i);
		}
		
		System.out.println(queue);
		
		for(int i = 0; i < 5; i++) {		
			queue.deque();
		}
		
		System.out.println(queue);
	}
}

interface Queue<E> {
	int size();
	boolean isEmpty();
	E first();
	void enque(E e);
	E deque();
}

class EmptyException extends RuntimeException {

}