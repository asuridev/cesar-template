package co.com.asuarezr.handlerExceptions.errorMessage;

public record ShortErrorMessage(
        String message,
        int statusCode
      ) implements ErrorMessage { }
