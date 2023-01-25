/**
 * Queue
 * A class that implements a queue. The queue
 * will use a linked list constructed by QueueElements.  
 * The queue allows the "setting" of any type of object.
 * @version 1.0.0
 * @author Ilyas Ahmed 
 * @since 2022-03-01
 */

import java.util.NoSuchElementException;

public class Queue<T> {
	// The front and the back of the queue.
	private QueueElement<T> front;
	private QueueElement<T> back;

	/**
	 * Constructs an empty Queue.
	 */
	public Queue () {
	
	}
	
	/**
	 * Returns true if the queue is empty.
	 */
	public boolean isEmpty () {
	    if (front == null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns the element at the head of the queue.
	 */
	public T peek () throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return front.getElement();
		}
	}
	
	/**
	 * Removes the front element of the queue.
	 */
	public void dequeue () throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			front = front.getNext();
		}
	}
	
	/**
	 * Puts an element on the back of the queue.
	 */
	public void enqueue (T element) {
		QueueElement<T> addElement = new QueueElement<T>(element, null);
		if (isEmpty()) {
			back = addElement;
			front = addElement;
		} else {
			back.setNext(addElement);
			back = addElement;
		}
	}
	
	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print () {
		QueueElement<T> printQueue = front;
		while (printQueue != null) {
			System.out.println(printQueue.getElement());
			printQueue = printQueue.getNext();
		}
	}
}