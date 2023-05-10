package eos.lkpspring.domain.services.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import eos.lkpspring.domain.models.Project;
import eos.lkpspring.domain.services.IProjectService;
import eos.lkpspring.domain.services.exception.ProjectNotFoundException;
import eos.lkpspring.repositories.ProjectRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements IProjectService {
  private ProjectRepository projectRepository;

  @Override
  public Project getOne(UUID id) {
    return projectRepository.findById(id)
        .orElseThrow(() -> new ProjectNotFoundException(id));

  }

}
