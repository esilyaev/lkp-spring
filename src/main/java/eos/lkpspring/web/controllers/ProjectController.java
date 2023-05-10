package eos.lkpspring.web.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eos.lkpspring.domain.models.Project;
import eos.lkpspring.repositories.ProjectRepository;
import eos.lkpspring.web.dto.CreateProjectDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("projects")
@AllArgsConstructor
@Slf4j
public class ProjectController {
  private ProjectRepository projectsRepository;

  @GetMapping
  List<Project> getAll() {
    log.info("Requested all projects");
    return projectsRepository.findAll();
  }

  @PostMapping
  Project createProject(@RequestBody CreateProjectDto projectDto) {
    log.info("Try to create Project with params: " + projectDto.toString());
    Project project = Project.builder()
        .name(projectDto.getName())
        .build();
    return projectsRepository.save(project);

  }
}
