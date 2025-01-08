package task3;

public abstract class LogHandler {
    protected LogHandler nextHandler;
    public void setNextHandler(LogHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    public void handleRequest(String message) {
        if (nextHandler != null) {
            nextHandler.handleRequest(message);
        }
    }
 }
