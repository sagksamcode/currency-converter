package com.wex.currencyconvert.exceptions;

import com.wex.currencyconvert.enums.IssueEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected Issue processExceptions(final Exception ex, final WebRequest request) {
        LOGGER.error(ex.getMessage(), ex);
        return new Issue(
                IssueEnum.UNEXPECTED_ERROR, Collections.singletonList(ex.getLocalizedMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected Issue handleMethodArgumentNotValid(
            final MethodArgumentNotValidException ex, final WebRequest request) {

        LOGGER.error(ex.getMessage(), ex);
        final List<String> errors = new ArrayList<>();

        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }

        for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        return new Issue(IssueEnum.BAD_REQUEST, errors);
    }

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    protected Issue processNotFoundException(final GlobalException ex, final WebRequest request) {
        LOGGER.error(String.valueOf(ex));
        return ex.getIssue();
    }


}
