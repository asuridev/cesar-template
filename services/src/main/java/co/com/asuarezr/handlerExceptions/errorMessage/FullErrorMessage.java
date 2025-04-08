package co.com.asuarezr.handlerExceptions.errorMessage;

import java.util.List;

public record FullErrorMessage(
        List<String> message,
        String error,
        int statusCode
      ) implements ErrorMessage { }
