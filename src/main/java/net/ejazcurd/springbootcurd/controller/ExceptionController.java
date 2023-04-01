package net.ejazcurd.springbootcurd.controller;


import net.ejazcurd.springbootcurd.exception.RecordNotFoundException;
import net.ejazcurd.springbootcurd.exception.UserNotFoundException;
import net.ejazcurd.springbootcurd.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
@Component
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(RecordNotFoundException ex, WebRequest request) {
        List<String> errors = new ArrayList<>();
        errors.add("Something went wrong..!!");
        ErrorResponse response = new ErrorResponse();
        response.setError(errors);
        response.setMessage(ex.getMessage());
        response.setMessage (ex.getLocalizedMessage ());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> UserNotFoundException(UserNotFoundException ex) {

        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }

}
