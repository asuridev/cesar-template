package co.com.asuarezr.handlerExceptions.customExceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(){

    }
    public NotFoundException(String message) {
        super(message);
    }
}
  