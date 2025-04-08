package co.com.asuarezr.handlerExceptions.customExceptions;

public class ForbiddenException extends RuntimeException {
    public ForbiddenException(){

    }
    public ForbiddenException(String message) {
        super(message);
    }
}
  