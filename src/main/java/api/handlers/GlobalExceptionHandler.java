package api.handlers;

import api.exceptions.WrongAgeException;
import api.model.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WrongAgeException.class)
    public ErrorInfo exceptionHandler(WrongAgeException exception, HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        String message = exception.getLocalizedMessage();

        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setUrl(url);
        errorInfo.setMessage(message);

        return errorInfo;
    }

}