package eos.lkpspring.domain.services.exception;

import java.util.UUID;

public class WorkTypeNotFoundException extends RuntimeException {
  public WorkTypeNotFoundException(UUID id) {
    super(String.format("WorkType with id: %s not found", id));
  }

}
