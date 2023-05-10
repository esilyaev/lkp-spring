package eos.lkpspring.domain.services.impl;

import java.util.UUID;

public class ContractorNotFoundException extends RuntimeException {
  public ContractorNotFoundException(UUID id) {
    super("Could found contractor with id: " + id);
  }
}
