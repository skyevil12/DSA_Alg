import list.*;

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
	
	public void enqueue(E e) throws FullCapacityException {
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
	
	public E dequeue() throws EmptyException {
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
			queue.enqueue(i);
		}
		
		System.out.println(queue);
		
		for(int i = 0; i < 5; i++) {		
			queue.dequeue();
		}
		
		System.out.println(queue);
		
		for(int i = 0; i < 5; i++) {		
			queue.enqueue(i);
		}
		
		System.out.println(queue);
		
		for(int i = 0; i < 5; i++) {		
			queue.dequeue();
		}
		
		System.out.println(queue);
	}
}

class SListQueue<E> implements Queue<E> {
	private SList mList;
	
	SListQueue() {
		mList = new SList();
	}
	
	public int size() {
		return mList.length();
	}
	
	public boolean isEmpty() {
		return mList.isEmpty();
	}
	
	public E first(){
		return (E)mList.front().item();
	}
	
	public void enqueue(E e) {
		mList.insertBack(e);
	}

	public E dequeue() {
		if(mList.isEmpty()) {
			throw new EmptyException();
		}
		
		ListNode first = mList.front();
		E target = (E)first.item();
		first.remove();
		return target;
	}
	
	@Override
	public String toString() {
		return "SListQueue: " + mList;
	}

	public static void main(String... args) {
		SListQueue queue = new SListQueue();
		for(int i = 0; i < 10; i++) {		
			queue.enqueue(i);
		}
		
		System.out.println(queue);
		
		for(int i = 0; i < 5; i++) {		
			queue.dequeue();
		}
		
		System.out.println(queue);
		
		for(int i = 0; i < 5; i++) {		
			queue.enqueue(i);
		}
		
		System.out.println(queue);
		
		for(int i = 0; i < 5; i++) {		
			queue.dequeue();
		}
		
		System.out.println(queue);
	}
}

interface Queue<E> {
	int size();
	boolean isEmpty();
	E first();
	void enqueue(E e);
	E dequeue();
}

class EmptyException extends RuntimeException {

}