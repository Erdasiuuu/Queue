public class EmptyQueue extends RuntimeException {

    public EmptyQueue(String message) {
        super(message);
    }

    public EmptyQueue(String message, Throwable cause) {
        super(message, cause);
    }
}
