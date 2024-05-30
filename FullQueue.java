/**
 * @brief класс для обработки полностью заполненной очереди
 *
 */
class FullQueue extends RuntimeException {
  public FullQueue() {
    super();
  }

  public FullQueue(String message) {
    super(message);
  }

  public FullQueue(String message, Throwable cause) {
    super(message, cause);
  }
}
