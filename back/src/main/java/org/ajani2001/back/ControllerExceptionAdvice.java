package org.ajani2001.back;

import org.ajani2001.back.exception.BadRequestException;
import org.ajani2001.back.exception.NotFoundException;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class ControllerExceptionAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DbActionExecutionException.class)
    public String dummy(DbActionExecutionException e) {
        e.printStackTrace();
        return "Operation can not be performed :(";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public String badRequest(BadRequestException e) {
        e.printStackTrace();
        return "Operation can not be performed :(";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public String notFound(NotFoundException e) {
        e.printStackTrace();
        return "Operation can not be performed :(";
    }
}
