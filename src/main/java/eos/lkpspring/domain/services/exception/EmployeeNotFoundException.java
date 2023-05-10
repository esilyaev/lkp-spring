package eos.lkpspring.domain.services.exception;

import java.util.UUID;

public class EmployeeNotFoundException extends RuntimeException {
  public EmployeeNotFoundException(UUID id) {
    super(String.format("Employee with id: %s not found", id));
  }

}
