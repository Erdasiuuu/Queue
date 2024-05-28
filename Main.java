import java.util.Scanner;

public class Main {
	public static void main(String[] argv) {
    Scanner scanner = new Scanner(System.in);
    int choice = 0;
    while (choice != Constants.EXIT_PROG.getValue()) {
	    Queue.printStartMenu();
	    choice = scanner.nextInt();
	    scanner.nextLine();
	    if (choice == Constants.PICK_STRING_QUEUE.getValue()) {
		    stringQueue(scanner);
	    }
	    else if (choice == Constants.PICK_INT_QUEUE.getValue()) {
		    intQueue(scanner);
	    }
	    else if (choice != Constants.EXIT_PROG.getValue()) {
		    printErrorInput();
	    }
	}
	}
	public static void stringQueue(Scanner scanner) {
		Queue<String> queue = new Queue<>();
		int choice = 0;
		while (choice != Constants.EXIT_QUEUE.getValue()) {
			Queue.printQueueMenu();
			choice = scanner.nextInt();
			scanner.nextLine();
			if (choice == Constants.CHECK_QUEUE.getValue()) {
				queue.checkEmptyQueue();
			}
			else if (choice == Constants.ENQUEUE.getValue()) {
				addStr(queue, scanner);
			}
			else if (choice == Constants.DEQUEUE.getValue()) {
				queue.dequeue();
			}
			else if (choice == Constants.PEEK.getValue()) {
				queue.peek();
			}
			else if (choice == Constants.DOUBLE_TAIL.getValue()) {
				queue.doubleTail();
			}
			else if (choice == Constants.EXTRACT.getValue()) {
				extractStr(queue, scanner);
			}
			else if (choice == Constants.DISPLAY.getValue()) {
				queue.display();
			}
			else if (choice != Constants.EXIT_QUEUE.getValue()) {
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
			Queue.printQueueMenu();
			choice = scanner.nextInt();
			scanner.nextLine();
			if (choice == Constants.CHECK_QUEUE.getValue()) {
				queue.checkEmptyQueue();
			}
			else if (choice == Constants.ENQUEUE.getValue()) {
				addInt(queue, scanner);
			}
			else if (choice == Constants.DEQUEUE.getValue()) {
				queue.dequeue();
			}
			else if (choice == Constants.PEEK.getValue()) {
				queue.peek();
			}
			else if (choice == Constants.DOUBLE_TAIL.getValue()) {
				queue.doubleTail();
			}
			else if (choice == Constants.EXTRACT.getValue()) {
				extractInt(queue, scanner);
			}
			else if (choice == Constants.DISPLAY.getValue()) {
				queue.display();
			}
			else if (choice != Constants.EXIT_QUEUE.getValue()) {
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
	  }
	  else {
          	System.out.printf("Значение не найдено в очереди\n");
	  }
  }


  public static void printErrorInput() {
    System.out.printf("\nНеверный ввод. Попробуйте еще раз\n");
  }
}
