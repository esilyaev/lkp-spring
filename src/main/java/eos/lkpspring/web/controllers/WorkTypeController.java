package eos.lkpspring.web.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eos.lkpspring.domain.models.WorkType;
import eos.lkpspring.domain.services.IWorkTypeService;
import eos.lkpspring.web.dto.WorkTypeCreateDto;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("worktype")
@AllArgsConstructor
public class WorkTypeController {
  private IWorkTypeService workTypeService;

  @GetMapping
  List<WorkType> getAll() {
    return workTypeService.getAll();
  }

  @GetMapping("{id}")
  WorkType getOne(@PathVariable UUID id) {
    return workTypeService.getOne(id);
  }

  @PostMapping
  WorkType createWorkType(@RequestBody WorkTypeCreateDto dto) {
    return workTypeService.createWorkType(dto);
  }
}
