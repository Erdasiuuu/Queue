import java.util.Scanner;

public class Main {
	public static void main(String[] argv) {
    Scanner scanner = new Scanner(System.in);
    int choice = 0;
    while (choice != Constants.EXIT_PROG.getValue()) {
	    printStartMenu();
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
				queue.checkEmptyStack();
			}
			else if (choice == Constants.ENQUEUE.getValue()) {
				queue.addStr();
			}
			else if (choice == Constants.DEQUEUE.getValue()) {
				queue.rmStr();
			}
			else if (choice == Constants.PEEK.getValue()) {
				queue.peek();
			}
			else if (choice == Constants.DOUBLE_TAIL.getValue()) {
				queue.doubleTail();
			}
			else if (choice == Constants.EXTRACT.getValue()) {
				queue.extractValue();
			}
			else if (choice == Constants.DISPLAY.getValue()) {
				queue.display();
			}
			else if (choice != Constants.EXIT_QUEUE.getValue()) {
				printErrorInput();
			}
		}
	}


	public static void intQueue(Scanner scanner) {
		Queue<Integer> queue = new Queue<>();
		int choice = 0;
		while (choice != Constants.EXIT_QUEUE.getValue()) {
			Queue.printQueueMenu();
			choice = scanner.nextInt();
			scanner.nextLine();
			if (choice == Constants.CHECK_QUEUE.getValue()) {
				queue.checkEmptyStack();
			}
			else if (choice == Constants.ENQUEUE.getValue()) {
				queue.addInt();
			}
			else if (choice == Constants.DEQUEUE.getValue()) {
				queue.rmInt();
			}
			else if (choice == Constants.PEEK.getValue()) {
				queue.peek();
			}
			else if (choice == Constants.DOUBLE_TAIL.getValue()) {
				queue.doubleTail();
			}
			else if (choice == Constants.EXTRACT.getValue()) {
				queue.extractValue();
			}
			else if (choice == Constants.DISPLAY.getValue()) {
				queue.display();
			}
			else if (choice != Constants.EXIT_QUEUE.getValue()) {
				printErrorInput();
			}
		}
	}

  public static void printStartMenu() {
    System.out.printf("Выберите тип данных для очереди\n");
    System.out.printf("1. String\n");
    System.out.printf("2. int\n");
    System.out.printf("3. Завершение программы\n");
  }


  public static void printErrorInput() {
    System.out.printf("\nНеверный ввод. Попробуйте еще раз\n");
  }
}
