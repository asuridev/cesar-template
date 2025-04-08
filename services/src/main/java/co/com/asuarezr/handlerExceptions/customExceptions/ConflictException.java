package co.com.asuarezr.handlerExceptions.customExceptions;

public class ConflictException extends RuntimeException {
    public ConflictException(){

    }
    public ConflictException(String message) {
        super(message);
    }
}
  