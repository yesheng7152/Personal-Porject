package supProb3;

public class Queue <PrintRequest>{
	private int front, rear, capacity; 
	private PrintRequest queue[]; 

	Queue(int c) 
	{ 
		front = rear = 0; 
		capacity = c; 
		queue = (PrintRequest[]) new Object[capacity];
	} 
	/**
	 * Determine if the queue is empty
	 * @return		True if the queue is empty (rear equal to zero)
	 */
	public boolean isEmpty() {  
		return (rear == 0); 
	} 

	/**
	 * Determine if the queue is full
	 * @return		true when rear is the same as capacity
	 */
	public boolean isFull() {
		return (capacity == rear);
	}

	/**
	 * function to insert an element at the rear of the queue 
	 * @param data		PrintRequest
	 */
	public void enqueue(PrintRequest data) 
	{ 
		// check queue is full or not 
		if (isFull())
			return; 
		// insert element at the rear 
		else { 
			queue[rear] = data; 
			rear++; 
		} 
		return; 
	} 

	/**
	 * function to delete an element from the front of the queue 
	 * 
	 * @return			PrintRequest or null when queue is empty
	 */
	public PrintRequest dequeue() 
	{ 
		// if queue is empty 
		if (isEmpty()) {
			return null;}
		// shift all the elements from index 2 till rear 
		// to the right by one 
		else { 
			PrintRequest item= queue[front];
			for (int i = 0; i < rear - 1; i++) { 
				queue[i] = queue[i + 1]; 
			} 
			queue[--rear] = null; 
			return item;
		}
	}

	/**
	 * @return the front
	 */
	public int getFront() {
		return front;
	}
	/**
	 * @return the rear
	 */
	public int getRear() {
		return rear;
	}
	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * @return the queue
	 */
	public PrintRequest[] getQueue() {
		return queue;
	}
	public void printQueue () {
		for (int head=0; head<rear; head++) {
			queue[head].toString();
		}
	}
} 

