package eos.lkpspring.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import eos.lkpspring.domain.services.impl.ContractorNotFoundException;

@ControllerAdvice
public class ContractorNotFoundAdvice {

  @ExceptionHandler(ContractorNotFoundException.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.NOT_FOUND)
  WebAppException userNotFoundHandler(ContractorNotFoundException ex) {
    return new WebAppException(ex.getMessage(), HttpStatus.NOT_FOUND.value());
  }
}
