package co.com.asuarezr.handlerExceptions.customExceptions;

public class BadRequestException extends RuntimeException{

  public BadRequestException(String msg){
    super(msg);
  }

  public BadRequestException(){}

}
