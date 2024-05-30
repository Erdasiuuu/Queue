import java.util.Scanner;

public class Main {
  /**
   * @brief Программа для работы с очередью
   *
   * Начальное меню предлагает выбрать какого типа данных будут элементы очереди
   * 1. String
   * 2. int
   *
   * После выбора типа данных используется меню для работы с очередью, которое имеет 8 опций
   * 1. Проверить пустая ли очередь
   * 2. Добавить элемент в хвост очереди
   * 3. Удалить элемент из головы очереди
   * 4. Получить голову очереди
   * 5. Продублировать хвост очереди
   * 6. Извлечь из очереди первое вхождение передаваемого значения
   * 7. Вывод очереди на экран
   * 8. Завершение работы со стеком этого типа
   *
   * Все необходимые данные будут запрашиваться до тех пор, пока не будут
   * введены полностью корректно. Например, при неправильном вводе количества
   * страниц программа снова будет запрашивать данные, до тех пор пока не будут
   * ввдены корректные данные
   *
   */

  public static void main(String[] argv) {
    Scanner scanner = new Scanner(System.in);
    int choice = 0;
    while (choice != Constants.EXIT_PROG.getValue()) {
      printStartMenu();
      choice = scanner.nextInt();
      scanner.nextLine();
      if (choice == Constants.PICK_STRING_QUEUE.getValue()) {
        stringQueue(scanner);
      } else if (choice == Constants.PICK_INT_QUEUE.getValue()) {
        intQueue(scanner);
      } else if (choice != Constants.EXIT_PROG.getValue()) {
        printErrorInput();
      }
    }
  }
  public static void stringQueue(Scanner scanner) {
    Queue<String> queue = new Queue<>();
    int choice = 0;
    while (choice != Constants.EXIT_QUEUE.getValue()) {
      printQueueMenu();
      choice = scanner.nextInt();
      scanner.nextLine();
      if (choice == Constants.CHECK_QUEUE.getValue()) {
        queue.checkEmptyQueue();
      } else if (choice == Constants.ENQUEUE.getValue()) {
        addStr(queue, scanner);
      } else if (choice == Constants.DEQUEUE.getValue()) {
        queue.dequeue();
      } else if (choice == Constants.PEEK.getValue()) {
        queue.peek();
      } else if (choice == Constants.DOUBLE_TAIL.getValue()) {
        queue.doubleTail();
      } else if (choice == Constants.EXTRACT.getValue()) {
        extractStr(queue, scanner);
      } else if (choice == Constants.DISPLAY.getValue()) {
        queue.display();
      } else if (choice != Constants.EXIT_QUEUE.getValue()) {
        printErrorInput();
      }
    }
  }

  public static void addStr(Queue<String> queue, Scanner scanner) {
    System.out.printf("Введите строку для добавления в очередь\n");
    String value = scanner.nextLine();
    queue.enqueue(value);
  }

  public static void extractStr(Queue<String> queue, Scanner scanner) {
    System.out.printf("Введите строку для удаления из очереди\n");
    String value = scanner.nextLine();
    boolean result = queue.extract(value);
    extractSuccess(result);
  }

  public static void intQueue(Scanner scanner) {
    Queue<Integer> queue = new Queue<>();
    int choice = 0;
    while (choice != Constants.EXIT_QUEUE.getValue()) {
      printQueueMenu();
      choice = scanner.nextInt();
      scanner.nextLine();
      if (choice == Constants.CHECK_QUEUE.getValue()) {
        queue.checkEmptyQueue();
      } else if (choice == Constants.ENQUEUE.getValue()) {
        addInt(queue, scanner);
      } else if (choice == Constants.DEQUEUE.getValue()) {
        queue.dequeue();
      } else if (choice == Constants.PEEK.getValue()) {
        queue.peek();
      } else if (choice == Constants.DOUBLE_TAIL.getValue()) {
        queue.doubleTail();
      } else if (choice == Constants.EXTRACT.getValue()) {
        extractInt(queue, scanner);
      } else if (choice == Constants.DISPLAY.getValue()) {
        queue.display();
      } else if (choice != Constants.EXIT_QUEUE.getValue()) {
        printErrorInput();
      }
    }
  }

  public static void addInt(Queue<Integer> queue, Scanner scanner) {
    System.out.printf("Введите число для добавления в очередь\n");
    int value = scanner.nextInt();
    scanner.nextLine();
    queue.enqueue(value);
  }

  public static void extractInt(Queue<Integer> queue, Scanner scanner) {
    System.out.printf("Введите число для его удаления из очереди\n");
    int value = scanner.nextInt();
    scanner.nextLine();
    boolean result = queue.extract(value);
    extractSuccess(result);
  }

  public static void extractSuccess(boolean value) {
    if (value) {
      System.out.printf("Значение удалено из очереди\n");
    } else {
      System.out.printf("Значение не найдено в очереди\n");
    }
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
  }

  public static void printErrorInput() {
    System.out.printf("\nНеверный ввод. Попробуйте еще раз\n");
  }
}
