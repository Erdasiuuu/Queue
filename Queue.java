/**
 * @brief Класс представляет из себя массив на 100 элементов, счетчик элементов, голову и хвост очереди.
 */
public class Queue<T> {
  private final int size = 100;
  private final T[] queueArray;
  private int elementsCount;
  private int head;
  private int tail;

  @SuppressWarnings("unchecked")
  public Queue() {
    queueArray = (T[]) new Object[size];
    elementsCount = 0;
    head = 0;
    tail = -1;
  }

  private boolean isEmpty() {
    return elementsCount == 0;
  }

  public void checkEmptyQueue() {
    if (isEmpty()) {
      System.out.printf("Очередь пуста\n");
     }
    else if (isFull()) {
      System.out.printf("Очередь полностью заполнена\n");
    } else {
      System.out.printf("Количество элементов в очереди: %d\n", elementsCount);
    }
  }

  private boolean isFull() {
    return elementsCount == size;
  }

  /**
   * @brief Добавление элемента в хвост очереди
   *
   * @param 
   *
   * Перед добавлением в хвост очереди элемента стоит заранее обработать случай выхода за предел массива, можно взять остаток от размера. Когда хвост будет указывать на последний элемент под инедксом 99, то сначала будет осуществлен инкремент для выбора следующего индекса и уже после остаток от деления на размер массива tail = ++99 % 100 = 0, хвост очереди будет указывать на начало массива. Очевидно это будет работать только в тех случаях, когда очередь не занимает весь массив.
   *
   */

  public void enqueue(T element) {
    if (isFull()) {
      throw new FullQueue(FullExceptionStr());
    }
    tail = ++tail % size;
    queueArray[tail] = element;
    elementsCount++;
  }

  /**
   * @brief Удаление элемента из головы очереди
   *
   * @param 
   *
   * Так как голова указывает на нужный элемент, то сначала берется элемент, а уже после индекс головы очереди смещается и отсекается в случае, если индекс вышел за предел массива.
   *
   */

  public T dequeue() {
    if (isEmpty()) {
      throw new EmptyQueue(EmptyExceptionStr());
    }
    T element = queueArray[head++];
    head %= size;
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
    enqueue(queueArray[tail]);
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
      System.out.printf("\n%d:%s%s", i, includeSpaces(i), element);
    }
    System.out.printf("\n");
  }

  private String includeSpaces(int value) {
    return " ".repeat(5 - String.valueOf(value).length());
  }

  private String EmptyExceptionStr() {
    return "Очередь пуста";
  }

  private String FullExceptionStr() {
    return "Очередь полностью заполнена";
  }
}
