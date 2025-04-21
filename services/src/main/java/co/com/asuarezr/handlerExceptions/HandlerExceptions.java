package co.com.asuarezr.handlerExceptions;

import co.com.asuarezr.handlerExceptions.customExceptions.*;
import co.com.asuarezr.handlerExceptions.errorMessage.ErrorMessage;
import co.com.asuarezr.handlerExceptions.errorMessage.FullErrorMessage;
import co.com.asuarezr.handlerExceptions.errorMessage.ShortErrorMessage;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.reactive.resource.NoResourceFoundException;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.server.ServerWebInputException;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class HandlerExceptions {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(WebExchangeBindException.class)
  @ResponseBody
  public ErrorMessage onWebExchangeBindException(WebExchangeBindException ex){
    List<String> messagesErrors = new ArrayList<>();
    ex.getBindingResult().getFieldErrors().forEach(error -> {
      messagesErrors.add(error.getField() + " " + error.getDefaultMessage());
    });
    return  new FullErrorMessage(messagesErrors,"BadRequest",HttpStatus.BAD_REQUEST.value());
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseBody
  public ErrorMessage onConstraintValidationException(ConstraintViolationException ex){
    List<String> errors = new ArrayList<>();
    ex.getConstraintViolations().forEach( error -> {
      errors.add(error.getMessage());
    });
    return  new FullErrorMessage(errors,"Bad Request",HttpStatus.BAD_REQUEST.value());
  }

  //Spring Exceptions
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({
          DuplicateKeyException.class,
          MethodNotAllowedException.class,
          ServerWebInputException.class,
          MethodArgumentTypeMismatchException.class,
          HttpMessageNotReadableException.class,
          NoResourceFoundException.class
          //DataIntegrityViolationException.class
  })
  @ResponseBody
  public ErrorMessage onSpringBadRequest(Exception ex){
    return new FullErrorMessage( List.of(ex.getClass().getSimpleName()), "Bad Request",HttpStatus.BAD_REQUEST.value());
  }

  // custom exceptions
  //------------------
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(BadRequestException.class)
  @ResponseBody
  public ErrorMessage onBadRequestException(BadRequestException ex) {
    if (ex.getMessage() == null) return new ShortErrorMessage("Bad Request", HttpStatus.BAD_REQUEST.value());
    return new FullErrorMessage(List.of(ex.getMessage()),"Bad Request", HttpStatus.BAD_REQUEST.value());
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NotFoundException.class)
  @ResponseBody
  public ErrorMessage onNotFoundException(NotFoundException ex) {
    if (ex.getMessage() == null) return  new ShortErrorMessage("Not Found", HttpStatus.NOT_FOUND.value());
    return new FullErrorMessage(List.of(ex.getMessage()), "Not Found", HttpStatus.NOT_FOUND.value());
  }

  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ExceptionHandler({
          UnauthorizedException.class,
          //BadCredentialsException.class, !todo descomentar con el modulo de seguridad
          //DisabledException.class,
          //LockedException.class
  })
  @ResponseBody
  public ErrorMessage onUnauthorizedException(Exception ex) {
    if (ex.getMessage() == null) return new ShortErrorMessage("Unauthorized", HttpStatus.UNAUTHORIZED.value());
    return new FullErrorMessage(List.of(ex.getMessage()), "Unauthorized", HttpStatus.UNAUTHORIZED.value());
  }

  @ResponseStatus(HttpStatus.FORBIDDEN)
  @ExceptionHandler(ForbiddenException.class)
  @ResponseBody
  public ErrorMessage onForbiddenException( ForbiddenException ex) {
    if (ex.getMessage() == null) return new ShortErrorMessage("Forbidden", HttpStatus.FORBIDDEN.value());
    return new FullErrorMessage(List.of(ex.getMessage()), "Forbidden", HttpStatus.FORBIDDEN.value());
  }

  @ResponseStatus(HttpStatus.CONFLICT)
  @ExceptionHandler(ConflictException.class)
  @ResponseBody
  public ErrorMessage onConflictException(ConflictException ex) {
    if (ex.getMessage() == null) return new ShortErrorMessage("Conflict", HttpStatus.CONFLICT.value());
    return new FullErrorMessage(List.of(ex.getMessage()), "Conflict", HttpStatus.CONFLICT.value());
  }

  //Internal Server Error
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception.class)
  @ResponseBody
  public ErrorMessage onServerError(Exception ex){
    return new FullErrorMessage(List.of(ex.getClass().getSimpleName()) ,"Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value());
  }

}
