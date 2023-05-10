package eos.lkpspring.domain.services;

import java.util.UUID;

import eos.lkpspring.domain.models.Project;

public interface IProjectService {
  Project getOne(UUID id);
}
