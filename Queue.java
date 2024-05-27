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

    public int peek() {
        if (isEmpty()) {
		throw new EmptyQueue(EmptyExceptionStr());
        }
        return queueArray[head];
    }
}
