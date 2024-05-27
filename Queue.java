import java.util.Scanner;

public class Queue<T> {
    private final int size = 100;
    private final T[] queueArray;
    private int elementsCount;
	private int head;
	private int tail;


    public Queue() {
        queueArray = (T[]) new Object[maxSize];
        elementsCount = 0;
	head = 0;
	tail = 0;
    }

    public boolean isEmpty() {
	    return elementsCount == 0;
    }

    public boolean isFull() {
	    return elementsCount == size;
    }

    public void enqueue(T element) {
        if (isFull()) {
		throw new FullQueue(fullExceptionStr());
        }
        queueArray[tail++] = element;
	tail %= size;
        elementsCount++;
    }

    public T dequeue() {
        if (isEmpty()) {
		throw new EmptyQueue(EmptyExceptionStr());
        }
        int element = queueArray[head--];
        head = (head + size) % size;
        elementsCount--;
        return element;
    }

    public T peek() {
        if (isEmpty()) {
		throw new EmptyQueue(EmptyExceptionStr());
        }
        return queueArray[head];
    }

    public void doubleTail() {
	enqueue(dequeue());
	elementsCount++;
    }
	
    public boolean extract(T element) {
        if (isEmpty()) {
		throw new EmptyQueue(EmptyExceptionStr());
        }
	    boolean removed = false;
	    int index = -1;
	    int current = head;
	    for (int i = 0; i < elementsCount && index == -1; i++) {
		    if (queueArray[current++].equals(element)) {
			    index = current - 1;
		    }
		    current %= size;
	     } 
	    if (index != -1) {
		elementsCount--;
		for (int i = index; i != tail; ) {
			current = i++;
			i %= size;
			queueArray[current] = queueArray[i];
		}
		removed = true;
	    }
	    		    


	    return removed;
    }
}
