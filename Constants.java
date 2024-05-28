public enum Constants {
  /**
   * @brief Константные переменные для дальнейшего использования
   *
   */
PICK_STRING_QUEUE(1),
PICK_INT_QUEUE(2),
EXIT_PROG(3),
CHECK_QUEUE(1),
ENQUEUE(2),
DEQUEUE(3),
PEEK(4),
DOUBLE_TAIL(5),
EXTRACT(6),
DISPLAY(7),
EXIT_QUEUE(8);

  private int value;

  Constants(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}
