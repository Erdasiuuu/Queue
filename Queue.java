import java.util.Scanner;

public class Queue<T> {
  private final int size = 3;
  private final T[] queueArray;
  private int elementsCount;
  private static int head;
  private static int tail;
  //govno

  @SuppressWarnings("unchecked")
  public Queue() {
    queueArray = (T[]) new Object[size];
    elementsCount = 0;
    head = -1;
    tail = -1;
  }

  public boolean isEmpty() {
    return elementsCount == 0;
  }

  public void checkEmptyQueue() {
	  if (isEmpty()) {
		  System.out.printf("Очередь пуста\n");
	  }
	  else {
		  System.out.printf("Количество элементов в очереди: %d\n", elementsCount);
	  }
  }



  public boolean isFull() {
    return elementsCount == size;
  }

  public void enqueue(T element) {
    if (isFull()) {
      throw new FullQueue(FullExceptionStr());
    }
    tail = ++tail % size;
    queueArray[tail] = element;
    elementsCount++;
  }



  public T dequeue() {
    if (isEmpty()) {
      throw new EmptyQueue(EmptyExceptionStr());
    }
    head = ++head % size;
    T element = queueArray[head];
    elementsCount--;
    System.out.printf("Голова очереди успешно удалена\n");
    return element;
  }

  public T peek() {
    if (isEmpty()) {
      throw new EmptyQueue(EmptyExceptionStr());
    }
    System.out.printf("\nГолова очереди: %s\n", queueArray[head]);
    return queueArray[head];
  }

  public void doubleTail() {
    if (isEmpty()) {
      throw new EmptyQueue(EmptyExceptionStr());
    }
    if (isFull()) {
      throw new FullQueue(FullExceptionStr());
    }
    try {
    enqueue(queueArray[tail]);
    } catch (Exception e) {
	    System.out.printf("\n\n%d %d\n\n", head, tail);
    }
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
      for (int i = index; i != tail;) {
        current = i++;
        i %= size;
        queueArray[current] = queueArray[i];
      }
      removed = true;
    }

    return removed;
  }

  public void display() {
    if (isEmpty()) {
      throw new EmptyQueue(EmptyExceptionStr());
    }
    int current = head;
    for (int i = 1; i <= elementsCount; i++) {
	    current %= size;
	    T element = queueArray[current++];
	    System.out.printf("\n%d:%s%s  %d", i, includeSpaces(i), element, current);
    }
    System.out.printf("\n");
  }

  private String includeSpaces(int value) {
	  return " ".repeat(5 - String.valueOf(value).length());
  }

  public String EmptyExceptionStr() {
	  return "Очередь пуста";
  }

  public String FullExceptionStr() {
	  return "Очередь полностью заполнена";
  }

  public static void printStartMenu() {
    System.out.printf("Выберите тип данных для очереди\n");
    System.out.printf("1. String\n");
    System.out.printf("2. int\n");
    System.out.printf("3. Завершение программы\n");
  }

  public static void printQueueMenu() {
    System.out.printf("\nВведите один из вариантов меню.\n");
    System.out.printf("1. Проверить пустая ли очередь\n");
    System.out.printf("2. Добавить элемент в хвост очереди\n");
    System.out.printf("3. Удалить элемент из головы очереди\n");
    System.out.printf("4. Получить голову очереди\n");
    System.out.printf("5. Продублировать хвост очереди\n");
    System.out.printf("6. Извлечь из очереди первое вхождение передаваемого значения\n");
    System.out.printf("7. Вывод очереди на экран\n");
    System.out.printf("8. Завершение работы со стеком этого типа\n");
    System.out.printf("head: %d tail:%d\n", head, tail);
  }
}
