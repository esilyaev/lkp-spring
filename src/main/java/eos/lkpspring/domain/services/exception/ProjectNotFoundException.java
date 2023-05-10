package eos.lkpspring.domain.services.exception;

import java.util.UUID;

public class ProjectNotFoundException extends RuntimeException {
  public ProjectNotFoundException(UUID id) {
    super(String.format("Project with id: %s not found", id));
  }

}
