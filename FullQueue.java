class FullQueue extends RuntimeException {

    public FullQueue(String message) {
        super(message);
    }

    public FullQueue(String message, Throwable cause) {
        super(message, cause);
    }
}
